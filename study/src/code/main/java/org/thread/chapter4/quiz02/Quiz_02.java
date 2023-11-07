package org.thread.chapter4.quiz02;

public class Quiz_02 {
    public static void main(String[] args) {
        Counter counter = new Counter("threadCounter", 10);
        counter.start();
    }
}
