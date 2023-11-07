package org.thread.chapter6.exam04;

public class SharedCounter extends Thread {
    private final SharedCount sharedCount;
    private final String name;
    private int count;
    private final int maxCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
    }

    @Override
    public void run() {
        System.out.println(this.name + " 시작");
        while (this.count < this.maxCount) {
            this.count++;
            this.sharedCount.increment();
        }
        System.out.println(this.name + " 종료");
    }
}
