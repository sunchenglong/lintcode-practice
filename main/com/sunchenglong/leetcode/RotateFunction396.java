package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/12.
 */
public class RotateFunction396 {
    public int maxRotateFunction(int[] A) {
        int max = 0;
        int sum = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            max += i * A[i];
            sum += A[i];
        }
        int tmp = max;
        for (int i = 1; i < length; i++) {
            tmp = tmp + sum - length * A[length - i];
            max = Math.max(tmp, max);
        }
        return max;
    }
}
