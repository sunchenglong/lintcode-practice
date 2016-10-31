package com.sunchenglong.leetcode;

import sun.text.resources.cldr.haw.FormatData_haw;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();

        HashSet<String> visited = new HashSet<>();
        int len = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String target = String.valueOf(chars);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}
