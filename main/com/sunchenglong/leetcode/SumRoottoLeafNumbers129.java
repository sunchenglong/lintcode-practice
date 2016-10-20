package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/20.
 */
public class SumRoottoLeafNumbers129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        int result = 0;
        return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
    }
}
