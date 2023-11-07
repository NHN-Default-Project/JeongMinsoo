package org.thread.chapter6.exam03;

public class SharedCount {
    private int count;

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        setCount(getCount() + 1);
    }
}
