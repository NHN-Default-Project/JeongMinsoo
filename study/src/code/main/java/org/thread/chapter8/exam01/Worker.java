package org.thread.chapter8.exam01;

public class Worker implements Runnable {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        System.out.println(getName() + " : Started! ");
        try {
            Thread.sleep(1999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(getName() + " : Finished!");
    }

    public static void test() {

    }
}
