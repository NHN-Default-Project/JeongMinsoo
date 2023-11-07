package org.thread.chapter4.exam1;

import static java.lang.Thread.sleep;

public class Counter implements Runnable {
    private String name;
    private int maxCount;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    public void run() {
        for (int i = 0; i <= maxCount; i++) {
            try {
                System.out.printf("%s : %d%n", this.name, i);

                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
