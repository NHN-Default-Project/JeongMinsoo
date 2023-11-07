package org.thread.chapter7.exam04;


public class Exam04 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter counter = new RunnableCounter("Counter", 10);

        WaitingCounter waitingCounter = new WaitingCounter(counter);

        counter.start();
        waitingCounter.start();

        Thread.State state = waitingCounter.getThread().getState();
        System.out.println(state);
        while (true) {
            if (state != waitingCounter.getThread().getState()) {
                state = waitingCounter.getThread().getState();
                System.out.println(state);

                if (state == Thread.State.TERMINATED) {
                    break;
                }
            }
        }
        System.out.println("Thread 종료!");


    }
}
