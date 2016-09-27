package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/27.
 */
public class CountandSay38 {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1; i < n; i++) {
            result = decode(result);
        }
        return result;
    }

    public String decode(String n) {
        int length = n.length();
        Character lastChar = n.charAt(0);
        int count = 0;
        String result = "";
        for (int i = 0; i < length; i++) {
            if(n.charAt(i) == lastChar ) {
                count ++;
            } else {
                result += String.valueOf(count) + lastChar;
                count = 1;
            }
            lastChar = n.charAt(i);
        }
        result += String.valueOf(count) + lastChar;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountandSay38().decode("1211"));
        System.out.println(new CountandSay38().countAndSay(6));
    }
}
