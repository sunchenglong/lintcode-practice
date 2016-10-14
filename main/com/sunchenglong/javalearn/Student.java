package com.sunchenglong.javalearn;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chenglong Sun on 2016/10/14.
 */
public class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private String name;
    private int age;
    private String email;
    private int id;

    public Student(String name, int age, String email, int id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public boolean equals(Object student) {
        return student instanceof Student && ((Student) student).name.equals(this.name);
    }

    public int hashCode() {
        return (id * 37 + 171);
    }

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 14, "zhangsan@qq.com", 1314141);
        Student student2 = new Student("zhangsan", 14, "zhangsan@qq.com", 144444);
        Student student3 = new Student("zhangsan", 13, "zhangsan@qq.com", 1314141);
        System.out.println(student1.equals(student2));
        System.out.println(student1.equals(student3));
        Set<Student> set = new HashSet<>();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        System.out.println(set.size());
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        set.forEach(System.out::println);
        Boolean a = new Boolean(true);
        Boolean b = new Boolean(false);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
