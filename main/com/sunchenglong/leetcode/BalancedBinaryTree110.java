package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/8.
 */
public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        else {
            return isBalancedNode(root) && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public boolean isBalancedNode(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
