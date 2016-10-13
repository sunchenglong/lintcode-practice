package com.sunchenglong.leetcode;

import com.sunchenglong.net.InetDemo01;

/**
 * Created by Chenglong Sun on 2016/8/9.
 */
public class StringtoInteger8 {
    public int myAtoi(String str) {
        if (str == null || str.equals("")) return 0;
        char[] chars = str.toCharArray();
        int flag = 1;
        int start = 0;
        int length = chars.length;
        long result = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                start = i + 1;
            } else {
                break;
            }
        }
        for (int i = start; i < length; i++) {
            if (chars[i] == '-') {
                flag = -1 * flag;
                start = i + 1;
                break;
            } else if (chars[i] == '+') {
                start = i + 1;
                break;
            } else {
                start = i;
                break;
            }
        }
        for (int i = start; i < length; i++) {
            if (chars[i] - 48 <= 9 && chars[i] - 48 >= 0) {
                result = result * 10 + chars[i] - 48;
                if (result * flag > Integer.MAX_VALUE || result * flag < Integer.MIN_VALUE)
                    return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else
                break;
        }
        return Integer.parseInt(String.valueOf(result * flag));
    }

    public static void main(String[] args) {
        System.out.println(new StringtoInteger8().myAtoi("11"));
    }
}
