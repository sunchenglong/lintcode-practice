package com.sunchenglong.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Chenglong Sun on 2016/9/26.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    TreeNode constructTree(int[] preorder, int lp, int rp, int[] inorder, int li, int ri) {
        if (lp >= preorder.length || lp >= rp || li >= ri) return null;
        TreeNode result = new TreeNode(preorder[lp]);
        int count = li;
        for (int i = li; i < ri; i++) {
            if (inorder[i] == preorder[lp]) {
                break;
            }
            count++;
        }
        result.left = constructTree(preorder, lp + 1, count - li + lp + 1, inorder, li, count);
        result.right = constructTree(preorder, rp - (ri - count - 1), rp, inorder, count + 1, ri);
        return result;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
