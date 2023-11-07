package org.thread.chapter7.exam02;


import org.thread.chapter5.quiz02.RunnableCounter;

public class exam02 {
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);

        runnableCounter.start();
        System.out.println(runnableCounter.getThread().getState());
        runnableCounter.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(runnableCounter.getThread().getState());

    }
}
