package org.thread.chapter5.quiz02;

public class RunnableCounter extends Thread {


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

    public void interrupt() {
        this.thread.interrupt();
    }

    @Override
    public void run() {
        try {
            while (true) {
                ++count;
                System.out.println(this.name + " : " + count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
        System.out.println(this.name + "상태 종료!");
    }


    public Thread getThread() {
        return this.thread;
    }
}
