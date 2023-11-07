package org.thread.chapter5.quiz01;

import java.util.concurrent.atomic.AtomicBoolean;

public class RunnableCounter implements Runnable {

    private AtomicBoolean stop; // stop Flag!

    private final String name;
    private int count;
    private final int maxCount;
    private Thread thread;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
        this.thread = new Thread(this, name);
        this.stop = new AtomicBoolean(false);
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {

        try {
            while (!this.stop.get()) {
                ++count;
                System.out.println(this.name + " : " + count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + "상태 종료!");
    }

    public void setStop(boolean bool) {
        this.stop = new AtomicBoolean(bool);
    }
}
