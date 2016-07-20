package com.sunchenglong.thread.thinking;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/20.
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable {

    public void run() {
        try {
            System.out.println("Starting ADaemon ..");
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This should always run?");
        }
    }
}