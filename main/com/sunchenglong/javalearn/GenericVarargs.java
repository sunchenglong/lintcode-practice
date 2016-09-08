package com.sunchenglong.javalearn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/9/8.
 */
public class GenericVarargs {
    public static <T> List<T> makelist(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = GenericVarargs.makelist("a");
        System.out.println(list.get(0));
        List<String> newlist = GenericVarargs.makelist("abcdedfff".split(""));
        for (String res : newlist) {
            System.out.println("RES==>" + res
            );
        }
    }
}
