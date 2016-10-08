package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/8.
 */
public class SymmetricTree101 {
    public class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            return isMirror(root.left, root.right);
        }

        public boolean isMirror(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val == right.val) {
                return isMirror(left.left, right.right) && isMirror(left.right, right.left);
            } else {
                return false;
            }
        }
    }
}
