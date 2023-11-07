package org.thread.chapter9.exam01;

public class Exam02 {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker("worker1", 100);

        worker.start();

        Thread.sleep(3000);
        worker.stop();
        System.out.println("메인 실행 종료!");
    }
}
