package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SleepDemo03 {
    public static void main(String[] args) throws InterruptedException {
        Sleep0312306 sleep0312306 = new Sleep0312306();
        Thread t1 = new Thread(sleep0312306, "路人甲");
        Thread t2 = new Thread(sleep0312306, "路人乙");
        Thread t3 = new Thread(sleep0312306, "工程师");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Sleep0312306 implements Runnable {
    private int num = 30;
    private boolean flag = true;

    public void run() {
        while (flag) {
            test2();
        }
    }

    private synchronized void test() {
        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了：" + num--);
    }

    private void test1() {
        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了：" + num--);
    }

    private void test2() {
        synchronized (this){
            if (num <= 0) {
                flag = false;
                return;
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

