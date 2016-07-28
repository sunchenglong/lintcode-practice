package com.sunchenglong.thread.thinking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/7/28.
 */
public class AttemptLocking {
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void untimed() {
        boolean captured = reentrantLock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if(captured) {
                reentrantLock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = reentrantLock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUtit.SECONDS)" + captured);
        } finally {
            if(captured)
                reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.untimed();
        attemptLocking.timed();
        new Thread() {
            {
                setDaemon(true);
            }
            public void run() {
                attemptLocking.reentrantLock.lock();
                System.out.println("acquired!");
            }
        }.start();
        Thread.yield();
        attemptLocking.untimed();
        attemptLocking.timed();
    }
}
