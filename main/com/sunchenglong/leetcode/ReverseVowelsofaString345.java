package com.sunchenglong.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/8/8.
 */
public class ReverseVowelsofaString345 {
    public String reverseVowels(String s) {
        if(s.equals("")) return "";
        Stack<Character> stack = new Stack<Character>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'
                    || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U') {
                stack.add(chars[i]);
                linkedList.add(i);
            }
        }
        int linkLength = linkedList.size()-1;
        for (int i = 0; i <= linkLength; i++) {
            chars[linkedList.get(i)] = stack.pop();
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsofaString345().reverseVowels("aeioe"));
    }
}
