package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SynDemo03 {
    public static void main(String[] args) {
        Object goods = new Object();
        Object money = new Object();
        Test1 test1 = new Test1(goods, money);
        Test2 test2 = new Test2(goods, money);
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        t1.start();
        t2.start();
    }
}

class Test1 implements Runnable {

    Object goods;
    Object money;

    public Test1(Object goods, Object money) {
        super();
        this.goods = goods;
        this.money = money;
    }

    public void run() {
        while (true) {
            test();
        }
    }

    private void test() {
        synchronized (goods) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (money) {
            }
        }
        System.out.println("请交钱");

    }
}


class Test2 implements Runnable {

    Object goods;
    Object money;

    public Test2(Object goods, Object money) {
        super();
        this.goods = goods;
        this.money = money;
    }

    public void run() {
        while (true) {
            test();
        }

    }

    private void test() {
        synchronized (money) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods) {
            }
        }
        System.out.println("请交货");
    }
}