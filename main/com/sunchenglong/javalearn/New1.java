package com.sunchenglong.javalearn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chenglong Sun on 2016/9/8.
 */
public class New1 {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = New1.map();
        map.put("abc", 1);
        System.out.println(map.get("abc"));
    }
}
