package com.sunchenglong.javalearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/25.
 */
public class ObjectPoolLearn {
    public static void test() {
        Integer a1 = 40;
        Integer a2 = 40;
        Integer a3 = 0;
        Integer b1 = new Integer(40);
        Integer b2 = new Integer(40);
        Integer b3 = new Integer(0);
        Integer c1 = 400;
        Integer c2 = 400;
        System.out.println("a1=a2: " + (a1 == a2));
        System.out.println("a1=a2+a3: " + (a1 == a2 + a3));
        System.out.println("b1=b2: " + (b1 == b2));
        System.out.println("b1=b2+b3: " + (b1 == b2 + b3));
        System.out.println("c1=c2: " + (c1 == c2));
        String d1 = "abc";
        String d2 = "abc";
        System.out.println("d1=d2: " + (d1 == d2));
        List<String> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        System.out.println("list(d1)=list(d2): " + (list.get(0) == list.get(1)));
        System.out.println("list(d1)=d1: " + (list.get(0) == d1));
        String e1 = new String("abc");
        String e2 = new String("abc");
        System.out.println("e1=e2: " + (e1 == e2));
        List<String> list2 = new ArrayList<>();
        list2.add(e1);
        list2.add(e2);
        System.out.println("list2(e1)=list(e2): " + (list2.get(0) == list2.get(1)));
        System.out.println("list2(e1)=e1: " + (list2.get(0) == e1));
        Boolean f1 = true;
        Boolean f2 = true;
        System.out.println("f1=f2: " + (f1 == f2));
        Boolean f3 = new Boolean(true);
        Boolean f4 = new Boolean(true);
        System.out.println("f3=f4: " + (f3 == f4));
        Double g1 = 3.14;
        Double g2 = 3.14;
        System.out.println("g1=g2: " + (g1 == g2));
        Double g3 = new Double(3.14);
        Double g4 = new Double(3.14);
        System.out.println("g3=g4: " + (g3 == g4));
        System.out.println("g3.equals(g4): " + (g3.equals(g4)));
    }

    public static void main(String[] args) {
        test();
    }
}
