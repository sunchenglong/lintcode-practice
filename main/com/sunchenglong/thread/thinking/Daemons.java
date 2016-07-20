package com.sunchenglong.thread.thinking;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/20.
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon () = " + d.isDaemon() + ", ");
        TimeUnit.MILLISECONDS.sleep(1);

    }
}

class Daemon implements Runnable {
    private Thread[] threads = new Thread[10];

    public void run() {
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            System.out.println("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < threads.length; i++) {
            System.out.println("threads[" + i + "].isDaemon() = " + threads[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

