package org.thread.chapter6.exam05;

/**
 * Data 클래스에서는 데이터 전송 요청이 올때, 전송이 완료된 상태면 메시지를 받아서 전달하고,
 * 그렇지 않으면 wait상태를 통해 Wating 상태로 전환된다.
 * 이때 WAITING상태가 되는 것은 sender이다.
 */
public class Data {
    private String packet;
    private boolean transfer;

    public Data() {
        this.packet = "";
        this.transfer = true;
    }

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                System.out.println("Send 대기중");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted!");
            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();

    }

    public synchronized String receive() {
        while (transfer) {
            try {
                System.out.println("Receive 대기중");

                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted!");
            }
        }
        transfer = true;
        notifyAll();
        return this.packet;
    }
}
