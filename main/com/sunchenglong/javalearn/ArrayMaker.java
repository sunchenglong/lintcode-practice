package com.sunchenglong.javalearn;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Chenglong Sun on 2016/9/13.
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return ((T[]) Array.newInstance(kind, size));
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringArrayMaker.create(5);
        System.out.println(Arrays.toString(stringArray));
    }
}
