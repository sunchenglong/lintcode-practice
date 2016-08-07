package com.sunchenglong.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/7.
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        int tmp;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            tmp = target - nums[i];
            if (!map.containsKey(tmp)) {
                map.put(nums[i], i);
            } else {
                result[0] = map.get(tmp);
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TwoSum1().twoSum(new int[]{1, 2, 3, 4, 5}, 9));
    }
}
