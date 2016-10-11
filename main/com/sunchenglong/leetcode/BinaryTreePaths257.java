package com.sunchenglong.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Chenglong Sun on 2016/9/29.
 */
//Todo Unfinished
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }

    public List<String> dfs(List<String> path, TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "asd", "xy");
        List<String> newlist = list.stream().map(s -> "root->" + s).collect(Collectors.toList());
        newlist.forEach(System.out::println);
        newlist.stream().map(s -> s.replaceAll("^root->", "")).collect(Collectors.toList()).forEach(System.out::println);

    }
}
