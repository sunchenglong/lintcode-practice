package com.sunchenglong.javalearn;

/**
 * Created by Administrator on 2016/7/18.
 */
public class ThreadTest extends Thread {
    @Override
    public void run(){
        for(int i = 0; i <= 10; i++){
            System.out.println("Start: " + i);
        }
    }

    public static void main(String[] args) {
        new ThreadTest().start();
        new ThreadTest().start();
    }
}
