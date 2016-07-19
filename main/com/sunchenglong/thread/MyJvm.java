package com.sunchenglong.thread;

/**
 * Created by Administrator on 2016/7/19.
 */

/**
 * 懒汉式
 */
public class MyJvm {
    private static MyJvm instance;

    private MyJvm() {

    }

    public static MyJvm getInstance() {
        if (null == instance) {
            synchronized (MyJvm.class) {
                if (null == instance) {
                    instance = new MyJvm();
                }
            }
        }
        return instance;
    }
}

/**
 * 饿汉式
 */
class MyJvm2 {
    private static MyJvm2 instance = new MyJvm2();

    private MyJvm2(){
    }
    public static MyJvm2 getInstance() {
        return instance;
    }
}


/**
 * 饿汉式 延缓加载时间
 */
class MyJvm3 {
    private static class JVMholder {
        private static MyJvm3 instance = new MyJvm3();

    }
    private MyJvm3(){
    }
    public static MyJvm3 getInstance() {
        return JVMholder.instance;
    }
}