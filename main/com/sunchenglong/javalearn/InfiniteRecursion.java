package com.sunchenglong.javalearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/8/25.
 */
public class InfiniteRecursion {
    public String toString() {
        return "InfiniteRecursion address:" + super.toString() +"\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
        int x= 123;
        System.out.printf("fd/%2sssf[/%%s]",x);
    }
}
