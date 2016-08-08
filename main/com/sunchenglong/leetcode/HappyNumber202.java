package com.sunchenglong.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/8/7.
 */
public class HappyNumber202 {
    public boolean isHappy(int n) {
        int tmp = square(n);
        Set <Integer> set = new HashSet<Integer>();
        while(true) {
            if (tmp == 1 || square(tmp) == tmp)
                return true;
            if(set.contains(tmp))
                return false;
            set.add(tmp);
            tmp = square(tmp);
        }
    }

    public int square(int n) {
        int result = 0;
        while (n != 0) {
            result += (n%10) * (n%10);
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber202().square(1));
        System.out.println(new HappyNumber202().isHappy(2));
    }
}
