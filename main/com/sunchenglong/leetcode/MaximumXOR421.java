package com.sunchenglong.leetcode;

import java.util.Map;

/**
 * Created by Chenglong Sun on 2016/10/16.
 */
public class MaximumXOR421 {

    public int findMaximumXOR(int[] nums) {
        if (nums.length <= 1) return 0;
        TrieNode trieNode = new TrieNode();
        for (int num : nums) {
            trieNode.insertNode(num);
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(trieNode.match(num), max);
        }
        return max;
    }
}

class TrieNode {
    private TrieNode[] trieNodes;

    TrieNode() {
        trieNodes = new TrieNode[2];
    }

    void insertNode(int word) {
        insertNode(word, this);
    }

    void insertNode(int word, TrieNode trieNode) {
        for (int i = 31; i >= 0; i--) {
            int id = (word >> i) & 1;
            if (trieNode.trieNodes[id] == null)
                trieNode.trieNodes[id] = new TrieNode();
            trieNode = trieNode.trieNodes[id];
        }
    }

    int match(int word) {
        return match(word, this);
    }

    int match(int word, TrieNode trieNode) {
        int result = 0;
        word = ~word;
        for (int i = 31; i >= 0; i--) {
            result = result << 1;
            int id = (word >> i) & 1;
            if (id == 0) {
                if (trieNode.trieNodes[id] != null) {
                    trieNode = trieNode.trieNodes[0];
                    result++;
                } else {
                    trieNode = trieNode.trieNodes[1];
                }
            } else {
                if (trieNode.trieNodes[id] != null) {
                    trieNode = trieNode.trieNodes[1];
                    result++;
                } else {
                    trieNode = trieNode.trieNodes[0];
                }
            }
        }
        return result;
    }
}
