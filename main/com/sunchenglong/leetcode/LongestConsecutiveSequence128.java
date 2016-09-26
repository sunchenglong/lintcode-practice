package com.sunchenglong.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chenglong Sun on 2016/9/26.
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, 0);
        }
        for (int num : nums) {
            int count = 1;
            if (map.get(num) == 0) {
                map.put(num, 1);
                int increase = num;
                int descrease = num;
                while (map.containsKey(++increase)) {
                    map.put(increase, 1);
                    count++;
                }
                while (map.containsKey(--descrease)) {
                    map.put(descrease, 1);
                    count++;
                }
            }
            result = result > count ? result : count;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence128().longestConsecutive(new int[]{0,1,2,3}));
    }
}
