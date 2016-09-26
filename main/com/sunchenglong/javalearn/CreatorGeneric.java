package com.sunchenglong.javalearn;

/**
 * Created by Chenglong Sun on 2016/9/26.
 */
abstract class GenericWithCreate<T> {

    final T element;

    GenericWithCreate() {
        this.element = create();
    }

    abstract T create();

}

class X {
}

class Creator extends GenericWithCreate<X> {

    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
