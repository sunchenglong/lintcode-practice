package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/8.
 */
public class IncreasingTripletSubsequence334 {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= first) {
                first = i;
            } else if (i <= second) {
                second = i;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
