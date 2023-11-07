package org.thread.chapter9.exam01;

public class RunnableCounter implements Runnable {
    private int interval = 1000;
    private final int maxNum;
    private final String name;
    private int count;

    private final Thread thread;

    public RunnableCounter(String name, int maxNum) {
        this.name = name;
        this.maxNum = maxNum;
        this.count = 0;
        this.thread = new Thread(this, name);
    }

    public void increment() {
        this.count++;
    }

    public void start() {
        thread.start();
    }


    @Override
    public void run() {
        System.out.println(this.name + " : 시작!");
        try {
            while (this.count < this.maxNum) {
                this.increment();
                System.out.println(this.thread.getName() + "의 카운트 : " + this.count);
                Thread.sleep(interval);
            }
            System.out.println(this.name + " : 작업 종료!");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public Thread getThread() {
        return this.thread;
    }

    public void setDaemon(boolean b) {
        this.thread.setDaemon(b);
    }

    public void stop() {
        this.thread.interrupt();
    }

    public void join() throws InterruptedException {
        this.thread.join();
    }
}
