package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SleepDemo01 {
    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        while (true) {
            System.out.println(num--);
            Thread.sleep(1000);
            if (num == 0)
                break;
        }
    }
}
