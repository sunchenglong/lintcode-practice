package com.sunchenglong.thread.pro;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Movie {
    private String pic;
    private boolean flag = true;
    // flag  -> true 生产者生产
    //flag  -> false 消费者消费

    public synchronized void play(String pic) {
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic = pic;
        this.notifyAll();
        this.flag = false;
    }

    public synchronized void watch(){
       if(flag){
           try {
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pic);
        this.notifyAll();
        this.flag = true;
    }
}
