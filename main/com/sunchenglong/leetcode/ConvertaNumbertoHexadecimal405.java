package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/24.
 */
public class ConvertaNumbertoHexadecimal405 {
    public String toHex(int num) {
        if (num == 0) return "0";
        String result = "";
        char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            result = table[num & 15] + result;
            num = (num >>> 4);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ConvertaNumbertoHexadecimal405().toHex(-1));
    }
}
