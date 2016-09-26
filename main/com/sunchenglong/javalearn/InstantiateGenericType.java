package com.sunchenglong.javalearn;

/**
 * Created by Chenglong Sun on 2016/9/26.
 */

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Employee {

}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> classAsFactory = new ClassAsFactory<Employee>(Employee.class);
        ClassAsFactory<Integer> classAsFactory1 = new ClassAsFactory<Integer>(Integer.class);
    }
}
