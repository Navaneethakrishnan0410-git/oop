package com.Logs.Logss;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class MultiThreadDemo {

    // Keywords to search in log files
    private static final List<String> KEYWORDS =
            Arrays.asList("error", "warning", "failed", "success");

    // Thread-safe global count map
    private static final ConcurrentHashMap<String, Integer> totalCounts =
            new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {

        String folderPath;

        // ---------------- OPTION: Scanner input if no arguments ----------------
        if (args.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter log folder path: ");
            folderPath = sc.nextLine().trim();
        } else {
            folderPath = args[0];
        }

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path: " + folderPath);
            return;
        }

        File[] logFiles = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (logFiles == null || logFiles.length == 0) {
            System.out.println("No log files found!");
            return;
        }

        System.out.println("Found " + logFiles.length + " log files.");

        int threadCount = 4; // fixed pool
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // ------------------- CONCURRENT EXECUTION -------------------
        long startConcurrent = System.currentTimeMillis();

        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        for (File file : logFiles) {
            futures.add(executor.submit(new LogWorker(file, KEYWORDS)));
        }

        for (Future<Map<String, Integer>> future : futures) {
            Map<String, Integer> result = future.get();
            mergeCounts(result);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endConcurrent = System.currentTimeMillis();

        // ------------------- SEQUENTIAL EXECUTION -------------------
        long startSequential = System.currentTimeMillis();

        Map<String, Integer> sequentialMap = new HashMap<>();
        for (File file : logFiles) {
            Map<String, Integer> r = processSequential(file);
            r.forEach((k, v) ->
                    sequentialMap.put(k, sequentialMap.getOrDefault(k, 0) + v)
            );
        }

        long endSequential = System.currentTimeMillis();

        // ----------------------------- OUTPUT -----------------------
        System.out.println("\n===== FINAL SUMMARY =====");
        totalCounts.forEach((k, v) ->
                System.out.println(k + " = " + v));

        writeOutputToFile(totalCounts);

        System.out.println("\nConcurrent Time: " + (endConcurrent - startConcurrent) + " ms");
        System.out.println("Sequential Time: " + (endSequential - startSequential) + " ms");

        System.out.println("\nCheck Task Manager to observe thread usage.");
    }

    // Combine results from worker into global map
    private static void mergeCounts(Map<String, Integer> workerResult) {
        workerResult.forEach((k, v) ->
                totalCounts.merge(k, v, Integer::sum)
        );
    }

    // Sequential version for comparison
    private static Map<String, Integer> processSequential(File file) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        for (String kw : KEYWORDS) {
            map.put(kw, 0);
        }

        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.map(String::toLowerCase)
                    .forEach(line -> {
                        for (String keyword : KEYWORDS) {
                            if (line.contains(keyword)) {
                                map.put(keyword, map.get(keyword) + 1);
                            }
                        }
                    });
        }

        return map;
    }

    // Write results to output file
    private static void writeOutputToFile(Map<String, Integer> result) {
        try (FileWriter writer = new FileWriter("log_result.txt")) {
            writer.write("=== Log Keyword Summary ===\n");
            for (String k : KEYWORDS) {
                writer.write(k + " = " + result.getOrDefault(k, 0) + "\n");
            }
            System.out.println("\nResults saved to log_result.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================================================================
    // =============== INNER CLASS: LOG WORKER THREAD ==================
    // ================================================================
    static class LogWorker implements Callable<Map<String, Integer>> {

        private final File file;
        private final List<String> keywords;

        public LogWorker(File file, List<String> keywords) {
            this.file = file;
            this.keywords = keywords;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> result = new HashMap<>();
            for (String kw : keywords) {
                result.put(kw, 0);
            }

            try (Stream<String> lines = Files.lines(file.toPath())) {
                lines.map(String::toLowerCase)
                        .forEach(line -> {
                            for (String keyword : keywords) {
                                if (line.contains(keyword)) {
                                    result.put(keyword, result.get(keyword) + 1);
                                }
                            }
                        });
            }

            System.out.println(Thread.currentThread().getName()
                    + " processed " + file.getName());

            return result;
        }
    }
}
