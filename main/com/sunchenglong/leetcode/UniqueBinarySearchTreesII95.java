package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class UniqueBinarySearchTreesII95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n <= 0) return result;
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> subTree = new ArrayList<>();
        if (start > end) {
            subTree.add(null);
            return subTree;
        }
        for (int k = start; k <= end; k++) {
            List<TreeNode> left = generateTrees(start, k - 1);
            List<TreeNode> right = generateTrees(k + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode mid = new TreeNode(k);
                    mid.left = l;
                    mid.right = r;
                    subTree.add(mid);
                }
            }
        }
        return subTree;
    }
}
