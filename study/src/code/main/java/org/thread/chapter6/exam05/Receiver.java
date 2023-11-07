package org.thread.chapter6.exam05;

public class Receiver implements Runnable {

    private final Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("수신 결과 : " + data.receive());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.println("Receiver 종료");
    }
}
