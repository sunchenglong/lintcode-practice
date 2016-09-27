package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/27.
 */
public class LengthofLastWord58 {

    public int lengthOfLastWord(String s) {
        String strings[] = s.split(" ");
        if(strings.length < 1) return 0;
        return strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(new LengthofLastWord58().lengthOfLastWord(" "));
    }
}
