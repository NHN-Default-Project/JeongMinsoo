package org.thread.chapter6.exam02;

public class SharedCounter extends Thread {
    private final String name;
    private int count;
    private final int maxCount;

    public SharedCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        System.out.println(this.name + " 시작");
        while (this.count < this.maxCount) {
            this.count++;
            SharedCount.increment();
        }
        System.out.println(this.name + " 종료");
    }
}
