package org.thread.chapter6.exam02;

public class Exam01 {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("카운터 1", 10_000);
        SharedCounter counter2 = new SharedCounter("카운터 2", 10_000);

        counter1.start();
        counter2.start();

        counter1.join();
        counter2.join();
        System.out.println("SharedCount : " + sharedCount.getCount());
    }
}
