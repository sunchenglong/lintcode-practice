package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SleepDemo02 {
    public static void main(String[] args) throws InterruptedException {
        NewWeb12306 newWeb12306 = new NewWeb12306();
        Thread t1 = new Thread(newWeb12306, "路人甲");
        Thread t2 = new Thread(newWeb12306, "路人乙");
        Thread t3 = new Thread(newWeb12306, "工程师");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

}

class NewWeb12306 implements Runnable {
    private int num = 50;

    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了：" + num--);
        }
    }
}