package com.sunchenglong.javalearn;

/**
 * Created by suncl on 16-7-15.
 */
public class ClassTest {

    static {
        System.out.println("ClassTest Loader");
    }

    public static void main(String[] args) {
        System.out.println("ClassTest Main Function");
        //A a = new A();
        System.out.println(A.width);
        System.out.println("First New A END!");
        //A a2 = new A();
    }
}

class B extends A {

    static {
        System.out.println("Class B loader!");
    }

}

class A extends AFather {

    static int width = 100;
    static final int max =1000;
    static {
        width = 300;
        System.out.println("Static Class Loader A");
        System.out.println(width);
    }

    A() {
        System.out.println("New Class A");
    }

}

class AFather {

    static {
        System.out.println("New Class AFather Static");
    }

    AFather() {
        System.out.println("New Class AFather Init");
    }

}

