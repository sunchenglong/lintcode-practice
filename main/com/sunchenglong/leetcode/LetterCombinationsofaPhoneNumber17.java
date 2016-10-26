package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/27.
 */
public class LetterCombinationsofaPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        String[] keyboard = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> input = new LinkedList<>();
        for (char c : digits.toCharArray()) {
            input.add(keyboard[c - '0']);
        }
        String path = "";
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        combine(input, 0, path, result);
        return result;
    }

    private void combine(List<String> input, int start, String path, List<String> result) {
        if (start == input.size()) {
            result.add(path);
        } else {
            for (int i = 0; i < input.get(start).length(); i++) {
                path = path + input.get(start).charAt(i);
                combine(input, start + 1, path, result);
                path = path.substring(0, path.length() - 1);
            }
        }
    }
}
