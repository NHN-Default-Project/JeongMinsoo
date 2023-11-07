package org.thread.chapter4.quiz04;

public class Quiz_04 {
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1", 10);
        Counter counter2 = new Counter("counter2", 10);
        counter1.start();
        counter2.start();
    }
}
