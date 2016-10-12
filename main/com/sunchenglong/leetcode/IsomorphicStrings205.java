package com.sunchenglong.leetcode;

import sun.applet.resources.MsgAppletViewer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Chenglong Sun on 2016/10/12.
 */
public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int length = s.length();
        for (Integer i = 0; i < length; i++) {
            if (map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
