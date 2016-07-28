package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */
public class    SynDemo01 {
    public static void main(String[] args) {
        Thread t1 = new JvmThread(10);
        Thread t2 = new JvmThread(50);
        t1.start();
        t2.start();
    }
}

class JvmThread extends Thread {

    private long time;

    public JvmThread() {
    }

    public JvmThread(long time) {
        this.time = time;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建:" + Jvm.getInstance2(time));
    }
}

/**
 * 单例设计模式
 */
class Jvm {
    private static Jvm instance = null;

    private Jvm() {
    }

    public static Jvm getInstance(long time) {
        if (null == instance) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Jvm();
        }
        return instance;
    }

    public static synchronized Jvm getInstance1(long time) {
        if (null == instance) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Jvm();
        }
        return instance;
    }

    /**
     * 懒汉式 double check
     * 双重检查
     * @param time
     * @return
     */
    public static Jvm getInstance2(long time) {
        if (null == instance) {
            synchronized (Jvm.class) {
                if (null == instance) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Jvm();
                }
            }
        }
        return instance;
    }
}