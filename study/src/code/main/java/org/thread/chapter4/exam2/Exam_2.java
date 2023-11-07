package org.thread.chapter4.exam2;

public class Exam_2 {
    public static void main(String[] args) {
        SelfRunnableCounter counter = new SelfRunnableCounter("Counter", 10);
        counter.start();
    }
}
