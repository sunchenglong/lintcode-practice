package com.sunchenglong.leetcode;


import java.util.*;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */

public class WordBreakII140 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return dfsSolver(s, new HashMap<>(), wordDict);
    }

    private List<String> dfsSolver(String s, HashMap<String, LinkedList<String>> map, Set<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> result = new LinkedList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfsSolver(s.substring(word.length()), map, wordDict);
                for (String sub : sublist) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(new WordBreakII140().wordBreak("catsanddog", set));
    }
}
