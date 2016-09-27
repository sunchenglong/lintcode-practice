package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/27.
 */
public class FlattenBinaryTreetoLinkedList114 {
    public void flatten(TreeNode root) {
        preOrder(root);
    }

    public TreeNode preOrder(TreeNode root) {
        if (root != null) {
            TreeNode left = preOrder(root.left);
            TreeNode right = preOrder(root.right);
            TreeNode dump = new TreeNode(-1);
            if (left != null) {
                dump.right = left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = right;
                root.left = null;
                root.right = dump.right;
            }else {
                root.left =null;
                root.right = right;
            }
            return root;
        } else {
            return null;
        }
    }
}
