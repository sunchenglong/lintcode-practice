package com.sunchenglong.leetcode;

import com.sunchenglong.javalearn.ArrayMaker;

import java.util.*;

/**
 * Created by Chenglong Sun on 2016/10/24.
 */
public class LargestDivisibleSubset368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (index != -1) {
            result.add(nums[index]);
            index = pre[index];
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new LargestDivisibleSubset368().largestDivisibleSubset(new int[]{1, 2, 4, 8, 9, 72});
        result.forEach(System.out::println);
    }
}
