package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class YieldDemo01 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        YieldDemo01 joinDemo01 = new YieldDemo01();
        Thread t = new Thread(joinDemo01);
        t.start();
        for (int i = 0; i < 10000; i++) {
            if (i % 20 == 0) {
                Thread.yield();
            }
            System.out.println("MainRun: " + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Yield : " + i);
        }
    }
}
