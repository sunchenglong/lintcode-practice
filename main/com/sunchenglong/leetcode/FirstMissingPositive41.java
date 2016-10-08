package com.sunchenglong.leetcode;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chenglong Sun on 2016/9/30.
 */
public class FirstMissingPositive41 {
    /**
     * 小心有重复的情况
     * BitSet解决方法
     */
    /*
    public static int firstMissingPositive(int[] nums) {
        BitSet set = new BitSet();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                set.set(nums[i]);
            }
        }
        return set.nextClearBit(1);
    }
*/
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0 || nums[i] > length || nums[i] == i + 1) i++;
            else  swap(nums, i + 1, nums[i]);
        }
        int i = 0;
        while (i < length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{0}));
    }
}
