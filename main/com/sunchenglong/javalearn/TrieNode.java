package com.sunchenglong.javalearn;

import sun.text.normalizer.Trie;

import java.io.*;
import java.util.HashSet;

/**
 * Created by Chenglong Sun on 2016/10/15.
 */
class TrieNode {
    private TrieNode[] childNodes;
    private int freq;
    public char nodeChar;
    public HashSet<Integer> hashSet = new HashSet<>();

    public TrieNode() {
        childNodes = new TrieNode[26];
        freq = 0;
    }

    public void addTrieNode(TrieNode root, String word, int id) {
        if (word.length() == 0) return;
        int k = word.charAt(0) - 'a';
        if (root.childNodes[k] == null) {
            root.childNodes[k] = new TrieNode();
            root.childNodes[k].nodeChar = word.charAt(0);
        }
        root.childNodes[k].hashSet.add(id);
        String nextWord = word.substring(1);

        if (nextWord.length() == 0)
            root.childNodes[k].freq++;
        addTrieNode(root.childNodes[k], nextWord, id);
    }

    public HashSet<Integer> searchTrie(String str) {
        return searchTrie(this, str, hashSet);
    }

    public HashSet<Integer> searchTrie(TrieNode root, String word, HashSet<Integer> hashSet) {
        if (word.length() == 0)
            return hashSet;
        int k = word.charAt(0) - 'a';
        String nextWord = word.substring(1);
        if (nextWord.length() == 0) {
            hashSet = root.childNodes[k].hashSet;
        }
        return searchTrie(root.childNodes[k], nextWord, root.childNodes[k].hashSet);
    }

    public int wordCount(String word) {
        return wordCount(this, word, 0);
    }

    public int wordCount(TrieNode root, String word, int count) {
        if (word.length() == 0)
            return count;
        int k = word.charAt(0) - 'a';
        String nextWord = word.substring(1);
        if (nextWord.length() == 0) {
            return root.childNodes[k].freq;
        }
        return wordCount(root.childNodes[k], nextWord, root.childNodes[k].freq);
    }

    public void updateTrieNode(String newWord, String oldWord, int id) {
        updateTrieNode(this, newWord, oldWord, id);
    }

    public void updateTrieNode(TrieNode root, String newWord, String oldWord, int id) {
        deleteTrieNode(root, oldWord, id);
        addTrieNode(root, newWord, id);
    }

    public void deleteTrieNode(TrieNode root, String word, int id) {
        if (word.length() == 0) return;
        int k = word.charAt(0) - 'a';
        if (root.childNodes[k] == null)
            return;
        String nextWord = word.substring(1);
        if (nextWord.length() == 0 && root.childNodes[k].freq > 0)
            root.childNodes[k].freq--;
        root.childNodes[k].hashSet.remove(id);
        deleteTrieNode(root.childNodes[k], nextWord, id);
    }

    public static void main(String[] args) throws IOException {
        TrieNode trieNode = new TrieNode();
        File file = new File("main/com/sunchenglong/javalearn/Text.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str;
        int i = 0;
        while ((str = bufferedReader.readLine()) != null) {
            trieNode.addTrieNode(trieNode, str, i++);
        }
        System.out.println(trieNode.wordCount("go"));
        trieNode.searchTrie("go").forEach(System.out::println);
        trieNode.updateTrieNode("go", "google", 0);
        System.out.println(trieNode.wordCount("go"));
        trieNode.updateTrieNode("google", "go", 0);
        System.out.println(trieNode.wordCount("go"));
    }
}
