package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfsHelper(n, n, "", result);
        return result;
    }

    void dfsHelper(int l, int r, String path, List<String> result) {
        if (l == 0 && r == 0) {
            result.add(path);
        } else if (l >= 0 && r >= 0 && r >= l) {
            if (l > 0)
                dfsHelper(l - 1, r, path + "(", result);
            if (r > l)
                dfsHelper(l, r - 1, path + ")", result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses22().generateParenthesis(3));
    }

}
