package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/20.
 */
public class BinaryTreeMaximumPathSum124 {
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        dfs(root);
        return max_sum;
    }

    private int max_sum;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val;
        if (left > 0) sum += left;
        if (right > 0) sum += right;
        max_sum = Math.max(max_sum, sum);
        return Math.max(right, left) > 0 ? Math.max(right, left) + root.val : root.val;
    }
}
