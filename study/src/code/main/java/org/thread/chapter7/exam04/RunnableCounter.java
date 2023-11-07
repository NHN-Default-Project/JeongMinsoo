package org.thread.chapter7.exam04;

public class RunnableCounter implements Runnable {
    private String name;
    private int maxCount;

    private int count;

    private Thread thread;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
        this.thread = new Thread(this, name);
    }

    public void start() {
        this.thread.start();
    }

    public void increment() {
        this.count++;
    }


    public int getCount() {
        return this.count;
    }


    public Thread getThread() {
        return this.thread;
    }

    public void join() throws InterruptedException {
        this.thread.join();
    }

    @Override
    public void run() {
        try {
            while (this.count < maxCount) {
                this.increment();
                System.out.println(this.name + " : " + this.getCount());
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
