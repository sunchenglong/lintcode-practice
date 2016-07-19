package com.sunchenglong.javalearn;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/7/19.
 */
public class CallTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Race tortoise = new Race("老不死", 1000);
        Race rabbit = new Race("小白兔", 500);
        Future <Integer> result1 = executorService.submit(tortoise);
        Future <Integer> result2 = executorService.submit(rabbit);

        Thread.sleep(2000);
        tortoise.setFlag(false);
        rabbit.setFlag(false);
        int num1 = result1.get();
        int num2 = result2.get();

        System.out.println("乌龟跑了 -->" + num1 + "步");
        System.out.println("兔子跑了 -->" + num2 + "步");

    }


}

class Race implements Callable<Integer> {
    private String name;
    private long time;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag = true;
    private int step;

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public Integer call() throws Exception {
        while (flag) {
            Thread.sleep(time);
            step++;
        }
        return step;
    }
}