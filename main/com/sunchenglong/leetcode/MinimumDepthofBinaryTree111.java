package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/27.
 */
public class MinimumDepthofBinaryTree111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return left + right + 1;
        } else {
            return (left < right ? left : right) + 1;
        }
    }

}
