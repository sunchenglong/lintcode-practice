package com.sunchenglong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class BinaryTreeInorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    /*
    private List<Integer> stack;


    public List<Integer> inorderTraversal(TreeNode root) {
        stack = new LinkedList<Integer>();
        dfs(root);
        return stack;
    }
    public void dfs(TreeNode treeNode) {
        if(treeNode != null) {
            dfs(treeNode.left);
            stack.add(treeNode.val);
            dfs(treeNode.right);
        }
    }
    */
}
