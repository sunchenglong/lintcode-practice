package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/18.
 */
public class SumofLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) return root.val;
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
