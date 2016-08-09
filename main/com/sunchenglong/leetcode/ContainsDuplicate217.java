package com.sunchenglong.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/8/9.
 */
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0 ) return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int n: nums){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
