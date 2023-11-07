package org.thread.chapter7.quiz02;

public class Quiz02 {
    Thread thread;

    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter1 = new RunnableCounter("counter1", 10);
        RunnableCounter runnableCounter2 = new RunnableCounter("counter2", 3);

        runnableCounter1.start();
        runnableCounter2.start();

        runnableCounter1.getThread().join();
        runnableCounter2.getThread().join();
        System.out.println("모든 쓰레드 종료");
    }
}
