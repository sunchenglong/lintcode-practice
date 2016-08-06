package com.sunchenglong.vm;

/**
 * Created by Administrator on 2016/8/5.
 */
public class TestGC {

    static int m = 1024 * 1024;

    public static void main(String[] args) {
        //分配2兆
        byte[] a1 = new byte[2 * m];
        System.out.println("a1 ok");
        //分配2兆
        byte[] a2 = new byte[2 * m];
        System.out.println("a2 ok");
    }
}
