package com.sunchenglong.thread.thinking;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;

/**
 * Created by suncl on 2016/7/30.
 */

class SleepBlocked implements Runnable {

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }

    public void run() {
        try {
            System.out.println("Waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException();
            }
        }
        System.out.println("Exiting Blocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }
    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService executorService =
            Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = executorService.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupted sent to " + r.getClass().getName());
    }
    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
