package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/9/29.
 */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
    }
}
