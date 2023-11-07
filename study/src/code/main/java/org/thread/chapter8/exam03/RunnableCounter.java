package org.thread.chapter8.exam03;

public class RunnableCounter implements Runnable {
    String name;
    int maxCount;

    int count;

    Thread thread;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
        this.thread = new Thread(this, name);
    }

    public RunnableCounter(ThreadGroup threadGroup, String name, int maxCount) {
        this.thread = new Thread(threadGroup, this, name);
        this.name = name;
        this.maxCount = maxCount;
    }

    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.thread.interrupt();
    }

    public void increment() {
        this.count++;
    }

    public boolean isAlive() {
        return this.thread.isAlive();
    }

    @Override
    public void run() {
        System.out.println(this.name + " 시작");
        try {
            while (this.count < maxCount) {
                this.increment();
                System.out.println(this.name + " : " + count);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(this.name + " 종료");
    }

    public int getCount() {
        return this.count;
    }


    public Thread getThread() {
        return this.thread;
    }

}
