package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/27.
 */
public class MaximumDepthofBinaryTree104 {

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root != null) {
            depth++;
            int right = maxDepth(root.right);
            int left = maxDepth(root.left);
            depth += right > left ? right : left;
        }
        return depth;
    }
}
