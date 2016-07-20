package com.sunchenglong.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/7/20.
 */
public class TimerDemo01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("so easy ...");
            }
        }, new Date(System.currentTimeMillis()+1000),200);
    }
}
