package org.thread.assignment.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Mart {

    private List<Store> storeList;
    private final AtomicInteger martSize;
    private AtomicInteger randNum;


    public Mart() {
        this.martSize = new AtomicInteger(StoreType.values().length);
        this.storeList = new ArrayList<>();
        this.randNum = new AtomicInteger(0);
        addStore();
    }

    private void addStore() {
        for (StoreType type : StoreType.values()) {
            this.storeList.add(new Store(type.name()));
        }
    }

    public void supply() throws InterruptedException {
        setRandNum();
        this.storeList.get(this.randNum.get()).buy();
    }


    public void enter() throws InterruptedException {
        setRandNum();
        Store tempStore = this.storeList.get(randNum.get());
        if (tempStore.getConsumerCount() < tempStore.getMaxConsumerCount()) {
            tempStore.enter();
            tempStore.sell();
            tempStore.exit();
        }
    }

    public synchronized void setRandNum() {
        this.randNum.set(ThreadLocalRandom.current().nextInt(1, this.martSize.get()));
    }

    private enum StoreType {
        축산매장,
        수산매장,
        빵집,
        피자집,
        삼성스토어,
        애플스토어,
        당X치킨,
        일반과자집;


    }

}
