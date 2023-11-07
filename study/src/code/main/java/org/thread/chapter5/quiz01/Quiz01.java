package org.thread.chapter5.quiz01;

public class Quiz01 {
    public static void main(String[] args) {
        RunnableCounter counter = new RunnableCounter("RunnableCount1", 10);
        RunnableCounter counter2 = new RunnableCounter("RunnableCount2", 10);

        counter.start();
        counter2.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        counter.setStop(true);
        counter2.setStop(true);

    }
}
