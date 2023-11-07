package org.thread.chapter6.exam05;

/**
 * Sender는 문자열을 data를 통해, Receiver는 data를 통해 문자열을 받는다.
 */
public class Sender implements Runnable {

    private final Data data;
    private int i;

    public Sender(Data data) {
        this.data = data;
        this.i = 0;
    }

    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
        try {
            while (true) {
                data.send(i++ + "번째 데이터");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
