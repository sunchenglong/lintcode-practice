package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Web12306 implements Runnable {
    private int num = 50;

    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "抢到了：" + num--);
        }
    }

    public static void main(String[] args) {
        Web12306 web12306 = new Web12306();
        Thread t1 = new Thread(web12306);
        Thread t2 = new Thread(web12306,"路人乙");
        Thread t3 = new Thread(web12306,"工程师");
        t1.start();
        t2.start();
        t3.start();
    }
}
