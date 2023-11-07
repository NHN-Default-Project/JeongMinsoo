package org.thread.연습문제;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 소비자는 매장에 입장 후 물건을 구매할 수 있다.
 * <p>
 * 매장에는 입장 인원 제한이 있으므로, 인원 초과시 기다린다.
 * <p>
 * 매장에 입장하면 물건을 구매하고, 퇴장한다.
 * <p>
 * 1~10초 간격으로 구매한다.
 */
public class Consumer implements Runnable {

    Store store;
    String name;
    Thread thread;
    int randNum;

    boolean isRun;


    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
        this.thread = new Thread(this, name);
        this.randNum = 0;
        this.isRun = true;
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            this.store.enter();
            System.out.println(this.name + " 입장! 현재 손님 수 : " + this.store.getConsumerCount());
            while (isRun) {
                int randNum = ThreadLocalRandom.current().nextInt(1, 11);
                Thread.sleep(randNum * 1_000L);
                this.store.sell();
                System.out.println(this.name + " 구매! 현재 물건 개수 : " + this.store.getGoodsCount());
                isRun = false;
            }
            this.store.exit();
            System.out.println(
                    this.name + " 퇴장! 현재 손님 수 : " + this.store.getConsumerCount());

        } catch (InterruptedException ignore) {

        }
    }
}
