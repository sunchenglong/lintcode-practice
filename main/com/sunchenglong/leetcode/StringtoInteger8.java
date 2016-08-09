package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/9.
 */
//// TODO: 2016/8/9  00 To Discuss
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
                if (result > Integer.MAX_VALUE) return 0;
            } else
                return 0;
        }
        return Integer.parseInt(String.valueOf(result)) * flag;
    }

    public static void main(String[] args) {
        System.out.println(new StringtoInteger8().myAtoi("-09939930292905299999999"));
        System.out.println(Integer.toBinaryString(68));
        System.out.println(Integer.toBinaryString(64).matches("^1(00)*$"));
        System.out.println(Integer.toBinaryString(2).matches("^1(0)*"));
    }
}
