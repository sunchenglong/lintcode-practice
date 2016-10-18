package com.sunchenglong.leetcode;


import java.util.*;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */

//Todo Unfinished
public class WordBreakII140 {
    Stack<String> path;
    List<String> result;

    public List<String> wordBreak(String s, Set<String> wordDict) {
        int length = s.length();
        if (length <= 0) return null;
        boolean[] f = new boolean[length + 1];
        f[0] = true;
        boolean[][] prev = new boolean[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    prev[i][j] = true;
                }
            }
        }
        if (f[length]) {
            path = new Stack<>();
            result = new ArrayList<>();
            dfs(s, prev, length, path, result);
            return result;
        } else {
            return null;
        }
    }

    public void dfs(String s, boolean[][] prev, int cur, Stack<String> path, List<String> result) {
        if (cur == 0) {
            StringBuilder stringBuilder = new StringBuilder("");
            for (String str : path) {
                stringBuilder.append(str).append(" ");
            }
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
            result.add(stringBuilder.toString());
        }
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (prev[cur][i]) {
                path.push(s.substring(i, cur - i));
                dfs(s, prev, i, path, result);
                path.pop();
            }
        }
    }
}
