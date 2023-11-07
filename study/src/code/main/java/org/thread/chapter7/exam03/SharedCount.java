package org.thread.chapter7.exam03;

public class SharedCount {
    int count = 0;

    public int getCount() {
        return this.count;
    }

    public synchronized void increment() {
        count++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {

        }
    }
}
