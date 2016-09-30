package com.sunchenglong.leetcode;

import java.util.List;

/**
 * Created by Chenglong Sun on 2016/9/29.
 */
//Todo Unfinished
public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }
    public void dfs(TreeNode root) {
        dfs(root.left);
        dfs(root.right);
    }
}
