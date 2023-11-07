package org.thread.chapter7.exam03;

public class SharedCounter implements Runnable {
    String name;
    int maxCount;

    SharedCount sharedCount;
    int count;

    Thread thread;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        this.name = name;
        this.sharedCount = sharedCount;
        this.maxCount = maxCount;
        this.count = 0;
        this.thread = new Thread(this, name);
    }

    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.thread.interrupt();
    }

    @Override
    public void run() {
        System.out.println(this.name + " 시작");
        try {
            while (this.count < maxCount) {
                this.count++;
                this.sharedCount.increment();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(this.name + " 종료");
    }


    public Thread getThread() {
        return this.thread;
    }
}
