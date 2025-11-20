package com.AlgorithmToolKit;

import java.util.*;
class SortingUtil {

    public static int[] bubbleSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return a;
    }

    public static int[] insertionSort(int[] arr) {
        int[] a = arr.clone();
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

    public static int[] mergeSort(int[] arr) {
        int[] a = arr.clone();
        mergeSortRec(a, 0, a.length - 1);
        return a;
    }

    private static void mergeSortRec(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortRec(a, left, mid);
        mergeSortRec(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(a, left, mid + 1);
        int[] R = Arrays.copyOfRange(a, mid + 1, right + 1);
        int i = 0, j = 0, k = left;

        while (i < L.length && j < R.length) {
            a[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < L.length) a[k++] = L[i++];
        while (j < R.length) a[k++] = R[j++];
    }

    public static int[] quickSort(int[] arr) {
        int[] a = arr.clone();
        quickSortRec(a, 0, a.length - 1);
        return a;
    }

    private static void quickSortRec(int[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSortRec(a, low, p - 1);
            quickSortRec(a, p + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
            }
        }
        int tmp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = tmp;
        return i + 1;
    }
}

class SearchUtil {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;
        return -1;
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

class CollectionUtil {
    public static class Stack<T> {
        private Node<T> top;
        private int size = 0;

        private static class Node<T> {
            T value;
            Node<T> next;
            Node(T v, Node<T> n) { value = v; next = n; }
        }

        public void push(T v) {
            top = new Node<>(v, top);
            size++;
        }

        public T pop() {
            if (top == null) throw new NoSuchElementException("Stack empty");
            T v = top.value;
            top = top.next;
            size--;
            return v;
        }

        public T peek() {
            if (top == null) throw new NoSuchElementException("Stack empty");
            return top.value;
        }

        public boolean isEmpty() { return top == null; }

        public int size() { return size; }
    }
    public static class Queue<T> {
        private Node<T> head, tail;
        private int size = 0;

        private static class Node<T> {
            T value; Node<T> next;
            Node(T v) { value = v; }
        }

        public void enqueue(T v) {
            Node<T> n = new Node<>(v);
            if (tail != null) tail.next = n;
            tail = n;
            if (head == null) head = n;
            size++;
        }

        public T dequeue() {
            if (head == null) throw new NoSuchElementException("Queue empty");
            T v = head.value;
            head = head.next;
            if (head == null) tail = null;
            size--;
            return v;
        }

        public T peek() {
            if (head == null) throw new NoSuchElementException("Queue empty");
            return head.value;
        }

        public boolean isEmpty() { return head == null; }

        public int size() { return size; }
    }
}
class AnalysisUtil {

    public static long timeMillis(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    public static double benchmarkMillis(Runnable task, int iterations) {
        task.run(); // warm-up
        long total = 0;
        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            task.run();
            long end = System.nanoTime();
            total += (end - start);
        }
        return (total / (double) iterations) / 1_000_000;
    }
}
public class AlgorithmToolkit {

    private static void printPass(String test) {
        System.out.println("[PASS] " + test);
    }

    public static void main(String[] args) {

        int[] a1 = {5, 2, 9, 1, 5, 6};
        int[] sorted1 = {1, 2, 5, 5, 6, 9};

        System.out.println(Arrays.toString(SortingUtil.bubbleSort(a1)));
        System.out.println(Arrays.toString(SortingUtil.insertionSort(a1)));
        System.out.println(Arrays.toString(SortingUtil.mergeSort(a1)));
        System.out.println(Arrays.toString(SortingUtil.quickSort(a1)));

        printPass("Sorting Algorithms");
        int[] data = {1,3,5,7,9};

        System.out.println("Linear Search 5 → " + SearchUtil.linearSearch(data, 5));
        System.out.println("Binary Search 7 → " + SearchUtil.binarySearch(data, 7));

        printPass("Searching Algorithms");
        CollectionUtil.Stack<Integer> stack = new CollectionUtil.Stack<>();
        stack.push(10); stack.push(20); stack.push(30);
        System.out.println("Stack pop → " + stack.pop());
        printPass("Stack");
        CollectionUtil.Queue<String> queue = new CollectionUtil.Queue<>();
        queue.enqueue("A"); queue.enqueue("B");
        System.out.println("Queue dequeue → " + queue.dequeue());
        printPass("Queue");
        long t1 = AnalysisUtil.timeMillis(() -> SortingUtil.mergeSort(a1));
        System.out.println("MergeSort time: " + t1 + " ms");

        double avg = AnalysisUtil.benchmarkMillis(() -> SortingUtil.quickSort(a1), 5);
        System.out.println("QuickSort average: " + avg + " ms");

        printPass("Analysis Util");

        System.out.println("All tests completed.");
    }
}
