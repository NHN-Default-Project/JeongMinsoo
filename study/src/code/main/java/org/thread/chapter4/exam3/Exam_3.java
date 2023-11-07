package org.thread.chapter4.exam3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exam_3 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.execute(new RunnableCounter("count1", 5));
        pool.execute(new RunnableCounter("count2", 5));

        pool.shutdown();
        System.out.println("Shutdown called");
        while (!pool.awaitTermination(2, TimeUnit.SECONDS)) {
        }
        System.out.println("All service finished");
    }
}
