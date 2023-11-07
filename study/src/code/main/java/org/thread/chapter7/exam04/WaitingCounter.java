package org.thread.chapter7.exam04;

public class WaitingCounter implements Runnable {

    private RunnableCounter runnableCounter;
    private Thread thread;

    public WaitingCounter(RunnableCounter runnableCounter) {
        this.runnableCounter = runnableCounter;
        this.thread = new Thread(this);
    }

    public void start() {
        this.thread.start();
    }


    public boolean isAlive() {
        return this.thread.isAlive();
    }

    public Thread getThread() {
        return this.thread;
    }

    @Override
    public void run() {
        try {
            runnableCounter.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
