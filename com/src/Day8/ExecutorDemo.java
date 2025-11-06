package com.Day8;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor=newFixedThreadPool(5);
        Runnable t1=()->{
            System.out.println("Thread is running: "+Thread.currentThread().getName());
        };
        for(int i=0;i<50;i++){
            executor.submit(t1);
        }
        executor.shutdown();
    }
}
