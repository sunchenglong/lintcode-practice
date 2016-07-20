package com.sunchenglong.thread.thinking;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/7/20.
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> future: futures
             ) {
            try {
                System.out.println(future.get());
                System.out.println(future);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
