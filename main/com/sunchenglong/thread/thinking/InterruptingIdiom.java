package com.sunchenglong.thread.thinking;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by suncl on 2016/8/1.
 */

class NeedsCleanup {
    private final int id;

    NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedCleanup " + this.id);
    }

    public void cleanup() {
        System.out.println("cleaning up " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedsCleanup needsCleanup1 = new NeedsCleanup(1);
                try {
                    System.out.println("Sleeing");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup needsCleanup2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Calculating ");
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                            System.out.println("Finished time-consuming operation");
                        }
                    } finally {
                        needsCleanup2.cleanup();
                    }
                } finally {
                    needsCleanup1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("usage: java InterruptingIdiom delay-in mS");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(20));
        t.interrupt();
    }
}

