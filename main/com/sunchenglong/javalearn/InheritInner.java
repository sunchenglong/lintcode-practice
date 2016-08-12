package com.sunchenglong.javalearn;

/**
 * Created by Chenglong Sun on 2016/8/12.
 */
class WithInner {
    class Inner {

    }
}
public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner wi){
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner inheritInner = new InheritInner(wi);
    }
}
