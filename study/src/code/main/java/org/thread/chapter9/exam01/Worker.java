package org.thread.chapter9.exam01;

public class Worker extends RunnableCounter {
    RunnableCounter runnableCounter;

    public Worker(String name, int maxNum) {
        super(name, maxNum);
        runnableCounter = new RunnableCounter("internal Worker", maxNum);
        runnableCounter.setDaemon(true);
    }

    @Override
    public void run() {
        runnableCounter.start();
        super.run();
    }
}
