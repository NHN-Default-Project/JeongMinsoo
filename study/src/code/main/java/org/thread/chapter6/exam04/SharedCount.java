package org.thread.chapter6.exam04;

public class SharedCount {
    private int count;

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }
}
