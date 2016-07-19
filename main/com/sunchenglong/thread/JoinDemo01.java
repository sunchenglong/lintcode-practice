package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class JoinDemo01 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        JoinDemo01 joinDemo01 = new JoinDemo01();
        Thread t = new Thread(joinDemo01);
        t.start();
        for (int i = 0; i < 100; i++) {
            if(50 == i){
                t.join();
            }
            System.out.println("MainRun: " + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("JoinDemo01Run: " + i);
        }
    }
}
