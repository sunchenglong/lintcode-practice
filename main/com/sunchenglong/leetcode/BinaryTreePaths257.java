package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Chenglong Sun on 2016/9/29.
 */

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (String tmp : left)
            result.add(String.valueOf(root.val) + "->" + tmp);
        for (String tmp : right)
            result.add(String.valueOf(root.val) + "->" + tmp);
        return result;
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "asd", "xy");
        List<String> newlist = list.stream().map(s -> "root->" + s).collect(Collectors.toList());
        newlist.forEach(System.out::println);
        newlist.stream().map(s -> s.replaceAll("^root->", "")).collect(Collectors.toList()).forEach(System.out::println);

    }
}
