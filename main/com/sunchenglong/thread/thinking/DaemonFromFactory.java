package com.sunchenglong.thread.thinking;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/7/20.
 */
public class DaemonFromFactory implements Runnable {
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started!");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
