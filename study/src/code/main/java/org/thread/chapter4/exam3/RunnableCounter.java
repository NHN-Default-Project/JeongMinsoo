package org.thread.chapter4.exam3;

public class RunnableCounter implements Runnable {
    private final String name;
    private int count;
    private final int maxCount;
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

    @Override
    public void run() {
        while (count < maxCount) {
            ++count;
            System.out.println(this.name + " : " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
