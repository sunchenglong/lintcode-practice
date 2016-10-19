package com.sunchenglong.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chenglong Sun on 2016/10/19.
 */
public class LRUcache1462 {
    private Map<Integer, Integer> map;

    public LRUcache1462(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void set(int key, int value) {
        map.put(key,value);
    }

    class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        int maximumCapasity;

        LinkedCappedHashMap(int maximumCapasity) {
            super(16, 0.75f, true);
            this.maximumCapasity = maximumCapasity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapasity;
        }
    }
}
