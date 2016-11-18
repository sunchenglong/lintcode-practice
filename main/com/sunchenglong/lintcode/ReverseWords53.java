package com.sunchenglong.lintcode;

/**
 * Created by suncl on 2016/11/18.
 */
public class ReverseWords53 {
    public String reverseWords(String s) {
        String[] tmp = s.replaceAll("\\s{1,}", " ")
                .replaceAll("\\s{1,}$", "")
                .replaceAll("^\\s{1,}", "")
                .split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            result.append(tmp[i]);
            result.append(" ");
        }
        return result.toString().replaceAll("\\s{1,}$", "");
    }

    public static void main(String[] args) {
        System.out.println(" f   f   a  ".replaceAll("\\s{1,}", " ").replaceAll("\\s{1,}$", "").replaceAll("^\\s{1,}", ""));
        System.out.println(new ReverseWords53().reverseWords("ad fd   ddf   "));
    }
}
