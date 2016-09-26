package com.sunchenglong.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chenglong Sun on 2016/9/26.
 */
public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = magazine.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }
        length = ransomNote.length();
        for (int i = 0; i < length; i++) {
            Character search = ransomNote.charAt(i);
            if (!map.containsKey(search) || map.get(search) == 0) {
                return false;
            } else {
                map.put(search, map.get(search) - 1);
            }
        }
        return true;
    }
}
