package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> result = pathSum(root);
        return result.contains(sum);
    }

    List<Integer> pathSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        List<Integer> left = pathSum(root.left);
        List<Integer> right = pathSum(root.right);
        for (int tmp : left)
            result.add(tmp + root.val);
        for (int tmp : right)
            result.add(tmp + root.val);
        return result;
    }
}
