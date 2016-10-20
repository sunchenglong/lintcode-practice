package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chenglong Sun on 2016/10/20.
 */
public class PathSumII113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> path = pathAll(root);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> tmp : path) {
            if (tmp.stream().mapToInt(i -> i).sum() == sum) {
                result.add(tmp);
            }
        }
        return result;
    }

    List<List<Integer>> pathAll(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        List<Integer> tmp;
        if (root.left == null && root.right == null) {
            tmp = new LinkedList<>();
            tmp.add(root.val);
            result.add(tmp);
            return result;
        }
        List<List<Integer>> left = pathAll(root.left);
        List<List<Integer>> right = pathAll(root.right);
        for (List<Integer> newTmp : left) {
            tmp = new LinkedList<>();
            tmp.add(root.val);
            tmp.addAll(newTmp);
            result.add(tmp);
        }
        for (List<Integer> newTmp : right) {
            tmp = new LinkedList<>();
            tmp.add(root.val);
            tmp.addAll(newTmp);
            result.add(tmp);
        }
        return result;
    }
}
