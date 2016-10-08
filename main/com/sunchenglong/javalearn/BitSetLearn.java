package com.sunchenglong.javalearn;

import java.util.BitSet;

/**
 * Created by Chenglong Sun on 2016/10/7.
 */
public class BitSetLearn {
    public static void test1() {
        BitSet bitSet = new BitSet();
        bitSet.set(23);
        System.out.println("bitSet size:" + bitSet.size());
        bitSet.set(54);
        System.out.println("bitSet size:" + bitSet.size());
        bitSet.set(67);
        System.out.println("bitSet size:" + bitSet.size());
        bitSet.set(320);
        System.out.println("bitSet size:" + bitSet.size());
        System.out.println("The true numbers: " + bitSet.cardinality());
        System.out.println("The nextClearBit: " + bitSet.nextClearBit(0));
        System.out.println("The nextSetBit: " + bitSet.nextSetBit(0));
        bitSet.xor(bitSet);
        System.out.println("The true numbers: " + bitSet.cardinality());
        System.out.println("12's numberOfTrailingZeros: " + Long.numberOfTrailingZeros(12));
    }

    public static void main(String[] args) {
        test1();
    }
}
