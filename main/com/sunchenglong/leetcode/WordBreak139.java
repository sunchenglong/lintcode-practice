package com.sunchenglong.leetcode;

import java.util.Set;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */
public class WordBreak139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int length = s.length();
        if (length <= 0) return false;
        boolean[] f = new boolean[length + 1];
        f[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i)))
                    f[i] = true;
            }
        }
        return f[length];
    }
}
