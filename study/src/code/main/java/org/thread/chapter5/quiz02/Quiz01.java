package org.thread.chapter5.quiz02;

public class Quiz01 {
    public static void main(String[] args) {
        RunnableCounter counter = new RunnableCounter("RunnableCount1", 10);
//        RunnableCounter counter2 = new RunnableCounter("RunnableCount2", 10);

        counter.start();
//        counter2.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("인터럽트 시도!");
        counter.interrupt();
    }
}
