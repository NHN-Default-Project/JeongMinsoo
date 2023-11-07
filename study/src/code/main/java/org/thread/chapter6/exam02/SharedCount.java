package org.thread.chapter6.exam02;

public class SharedCount {
    private static int count;

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static synchronized void increment() {
        count++;
    }
}
