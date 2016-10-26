package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class LowestCommonAncestorofaBinarySearchTree235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
