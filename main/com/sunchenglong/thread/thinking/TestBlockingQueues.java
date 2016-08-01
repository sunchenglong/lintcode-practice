package com.sunchenglong.thread.thinking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by suncl on 2016/8/1.
 */
public class TestBlockingQueues {
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<ListOff> queue) {
        System.out.println(msg);
        ListOffRunner listOffRunner = new ListOffRunner(queue);
        Thread thread = new Thread(listOffRunner);
        thread.start();
        for (int i = 0; i < 5; i++) {
            listOffRunner.add(new ListOff(5));
        }
        getkey("Press 'Enter' (" + msg + ")");
        thread.interrupt();
        System.out.println("Finished " + msg + "test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<ListOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<ListOff>(3));
        test("SychronouseQueue", new SynchronousQueue<ListOff>());
    }
}

class ListOffRunner implements Runnable {
    private BlockingQueue<ListOff> rokets;

    public ListOffRunner(BlockingQueue<ListOff> queue) {
        rokets = queue;
    }

    public void add(ListOff listOff) {
        try {
            rokets.put(listOff);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                ListOff rocket = rokets.take();
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting ListOffRunner");
    }
}

