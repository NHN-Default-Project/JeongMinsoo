package org.thread.chapter8.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for (int i = 1; i <= 10; i++) {
            executorService.submit(new Worker("Worker" + i));
        }

        executorService.shutdown();

    }
}
