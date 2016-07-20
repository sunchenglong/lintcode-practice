package com.sunchenglong.thread.thinking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/7/20.
 */
public class ListOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public ListOff() {
    }

    public ListOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Listoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}

class MainThread {
    public static void main(String[] args) {
        testExecutor();
    }

    public static void testTread() {
        for (int i = 0; i < 5; i++) {
            new Thread(new ListOff()).start();
        }
        System.out.println("Waiting for ListOff");
    }

    public static void testExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ListOff());
        }
        executorService.shutdown();
    }
}