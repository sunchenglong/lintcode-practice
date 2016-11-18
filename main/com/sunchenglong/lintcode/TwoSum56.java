package com.sunchenglong.lintcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suncl on 2016/11/18.
 */
public class TwoSum56 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= numbers.length; i++) {
            if (map.containsKey(numbers[i - 1])) {
                if (numbers[i - 1] * 2 == target) {
                    result[0] = map.get(numbers[i - 1]);
                    result[1] = i;
                    return result;
                }
            } else {
                map.put(numbers[i - 1], i);
            }
        }
        for (int i = 1; i <= numbers.length; i++) {
            if (map.containsKey(target - numbers[i - 1])) {
                result[0] = i;
                result[1] = map.get(target - numbers[i - 1]);
                return result;
            }
        }
        return result;
    }
}
