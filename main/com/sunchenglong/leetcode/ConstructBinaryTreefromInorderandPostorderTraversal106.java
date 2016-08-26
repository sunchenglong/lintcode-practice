package com.sunchenglong.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/25.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
            if (ir - il < 0 || pr - pl < 0 || il < 0 || pl < 0) return null;
            else if (ir - il == 0) {
                return new TreeNode(inorder[ir]);
            } else {
                TreeNode result = new TreeNode(postorder[pr]);
                int media = 0;
                for (int i = il; i <= ir; i++) {
                    if (postorder[pr] == inorder[i]) {
                        media = i;
                    }
                }
                result.left = buildTree(inorder, il, media - 1, postorder, pl, pl - il + media - 1);
                result.right = buildTree(inorder, media + 1, ir, postorder, pr - ir + media, pr - 1);
                return result;
            }
        }

    }

    public static void main(String[] args) {
        int[] inorder = new int[]{3, 2, 1};
        int[] postorder = new int[]{1, 2, 3};
        ConstructBinaryTreefromInorderandPostorderTraversal106 constructBinaryTreefromInorderandPostorderTraversal106 = new ConstructBinaryTreefromInorderandPostorderTraversal106();
        TreeNode treenode = constructBinaryTreefromInorderandPostorderTraversal106.new Solution().buildTree(inorder, postorder);
    }

}

