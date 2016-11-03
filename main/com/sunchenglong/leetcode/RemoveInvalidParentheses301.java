package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by suncl on 2016/11/3.
 */
public class RemoveInvalidParentheses301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int lastI, int lastJ, char[] par) {
        for (int stack = 0, i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else
            ans.add(reversed);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses301().removeInvalidParentheses("(a)())()"));
    }

}
