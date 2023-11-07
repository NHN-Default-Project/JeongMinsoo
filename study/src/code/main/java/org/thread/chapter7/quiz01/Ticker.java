package org.thread.chapter7.quiz01;

import java.util.regex.Pattern;

public class Ticker implements Runnable {
    private static String nanoPattern = "[\\d*n]$";
    private static String miliPattern = "[\\d*]$";
    private final Thread thread;
    private final Tick tick;
    private long tickNum;
    private long nanoTickNum;

    private boolean isMiliSec;

    public Ticker(Tick tick) {
        this.thread = new Thread(this);
        this.tick = tick;

    }

    private void tickInit(String tick) {
        tick = tick.toLowerCase();
        if (Pattern.compile(miliPattern).matcher(tick).find()) {
            this.tickNum = Long.parseLong(tick);
            this.isMiliSec = true;
        } else if (Pattern.compile(nanoPattern).matcher(tick).find()) {
            tick = tick.replace("n", "");
            this.nanoTickNum = Long.parseLong(tick);
            this.isMiliSec = false;
        } else {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }
    }

    public long getTickNum() {
        return isMiliSec ? this.tickNum : this.nanoTickNum;
    }

    public void start(String tick) {
        tickInit(tick);

        this.tick.setTick(getTickNum());

        this.thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("tick! " + tick.getTick());
                if (isMiliSec) {
                    Thread.sleep(tick.getTick());
                } else {
                    Thread.sleep(1, (int) tick.getTick());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
