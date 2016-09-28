package com.sunchenglong.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] notPrime = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                result++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes204().countPrimes(499979));
    }
}
