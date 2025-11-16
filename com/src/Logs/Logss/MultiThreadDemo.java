package com.Logs.Logss;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class MultiThreadDemo {

    // Keywords to search in log files
    private static final List<String> KEYWORDS =
            Arrays.asList("error", "warning", "failed", "success");

    // Thread-safe global count map
    private static final ConcurrentHashMap<String, Integer> totalCounts =
            new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Usage: java Main <folderPath>");
            return;
        }

        String folderPath = args[0];
        File folder = new File(folderPath);

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
        long endConcurrent = System.currentTimeMillis();

        // --------------------- SEQUENTIAL EXECUTION -----------------
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

        System.out.println("\nConcurrent Time: " +
                (endConcurrent - startConcurrent) + " ms");

        System.out.println("Sequential Time: " +
                (endSequential - startSequential) + " ms");

        System.out.println("\nView Task Manager to observe thread usage.");
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
        List<String> lines = Files.readAllLines(file.toPath());

        for (String keyword : KEYWORDS) {
            long count = lines.stream()
                    .filter(line -> line.toLowerCase().contains(keyword))
                    .count();
            map.put(keyword, (int) count);
        }

        return map;
    }

    // Write results to output file
    private static void writeOutputToFile(Map<String, Integer> result) {
        try (FileWriter writer = new FileWriter("log_result.txt")) {
            writer.write("=== Log Keyword Summary ===\n");
            for (String k : result.keySet()) {
                writer.write(k + " = " + result.get(k) + "\n");
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

            List<String> lines = Files.readAllLines(file.toPath());

            for (String keyword : keywords) {
                long count = lines.stream()
                        .filter(line -> line.toLowerCase().contains(keyword))
                        .count();
                result.put(keyword, (int) count);
            }

            System.out.println(Thread.currentThread().getName()
                    + " processed " + file.getName());

            return result;
        }
    }
}

