package org.thread.chapter4.quiz05;

public class Quiz_05 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Counter("runnableCounter", 10));
        thread.start();
    }
}
