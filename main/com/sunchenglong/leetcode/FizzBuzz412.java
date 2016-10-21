package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String tmp;
            if (i % 3 == 0 && i % 5 == 0) {
                tmp = "FizzBuzz";
            } else if (i % 3 == 0) {
                tmp = "Fizz";
            } else if (i % 5 == 0) {
                tmp = "Buzz";
            } else {
                tmp = String.valueOf(i);
            }
            result.add(tmp);
        }
        return result;
    }
}
