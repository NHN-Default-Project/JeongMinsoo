package org.thread.chapter7.quiz01;

public class Tick {
    long tick = 0;

    public long getTick() {
        return this.tick;
    }

    public void setTick(long tick) {
        this.tick = tick;
    }

    public synchronized long out() {
        return tick;
    }
}
