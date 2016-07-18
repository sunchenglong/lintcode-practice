package com.sunchenglong.javalearn;

/**
 * Created by Administrator on 2016/7/18.
 */
public class StaticProxy {
    public static void main(String[] args) {
        Imarry tomMarry = new Tom();
        Imarry marryCompany = new MarryCompany(tomMarry);
        marryCompany.marry();
    }

}

interface Imarry {
    void marry();
}

class Tom implements Imarry {

    public void marry() {
        System.out.println("Tom is marrying ...");
    }
}

class MarryCompany implements Imarry {

    private Imarry imarry;

    public MarryCompany(Imarry imarry) {
        this.imarry = imarry;
    }

    private void beforeMary() {
        System.out.println("Before Marry ....");
    }

    private void afterMarry() {
        System.out.println("After Marry ....");
    }

    public void marry() {
        beforeMary();
        imarry.marry();
        afterMarry();
    }
}