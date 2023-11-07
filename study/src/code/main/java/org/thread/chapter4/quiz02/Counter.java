package org.thread.chapter4.quiz02;

public class Counter extends Thread {
    private String name;
    private int maxCount;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        for (int i = 0; i <= maxCount; i++) {
            try {
                System.out.printf("%s : %d%n", this.name, i);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
