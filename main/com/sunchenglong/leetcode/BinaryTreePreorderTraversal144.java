package com.sunchenglong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/10/19.
 */
public class BinaryTreePreorderTraversal144 {
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        if (p != null) stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            result.add(p.val);
            if (p.right != null) stack.push(p.right);
            if (p.left != null) stack.push(p.left);
        }
        return result;
    }
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode cur = root;
        TreeNode prev = new TreeNode(-1);
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) {
                    result.add(cur.val);
                    node.right = cur;
                    prev = cur;
                    cur = cur.left;
                } else {
                    node.right = null;
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}