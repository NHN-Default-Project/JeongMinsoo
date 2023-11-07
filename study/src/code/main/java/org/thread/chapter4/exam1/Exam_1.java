package org.thread.chapter4.exam1;

public class Exam_1 {
    public static void main(String[] args) {
        Counter counter = new Counter("runnableCounter", 10);
        Thread thread = new Thread(counter);
        thread.start();
    }
}
