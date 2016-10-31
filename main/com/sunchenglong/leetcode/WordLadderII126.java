package com.sunchenglong.leetcode;

import java.io.StringBufferInputStream;
import java.util.*;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class WordLadderII126 {
    Map<String, List<String>> map;
    List<List<String>> results;

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        results = new ArrayList<>();
        if (wordList.size() == 0)
            return results;
        int min = Integer.MAX_VALUE;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        map = new HashMap<>();
        Map<String, Integer> ladder = new HashMap<>();
        for (String string : wordList)
            ladder.put(string, Integer.MAX_VALUE);
        ladder.put(beginWord, 0);
        wordList.add(endWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if (step > min) break;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    stringBuilder.setCharAt(i, ch);
                    String newWord = stringBuilder.toString();
                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord))
                            continue;
                        else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }
                        if (map.containsKey(newWord))
                            map.get(newWord).add(word);
                        else {
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }
                        if (newWord.equals(endWord))
                            min = step;
                    }
                }
            }
        }
        LinkedList<String> result = new LinkedList<>();
        backTrace(endWord, beginWord, result);
        return results;
    }

    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for (String string : map.get(word))
                backTrace(string, start, list);
        list.remove(0);
    }
}
