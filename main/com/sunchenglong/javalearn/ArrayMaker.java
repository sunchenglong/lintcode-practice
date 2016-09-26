package com.sunchenglong.javalearn;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringArrayMaker.create(5);
        System.out.println(Arrays.toString(stringArray));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.getClass().getMethod("add", Object.class).invoke(arrayList,"asd");
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
