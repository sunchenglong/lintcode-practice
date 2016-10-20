package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ChengLong Sun on 2016/10/20.
 */
public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;
        TreeNode cur = root;
        TreeNode prev;
        do {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            prev = null;
            while (!stack.isEmpty()) {
                cur = stack.pop();
                if (cur.right == prev) {
                    result.add(cur.val);
                    prev = cur;
                } else {
                    stack.push(cur);
                    cur = cur.right;
                    break;
                }
            }
        } while (!stack.isEmpty());
        return result;
    }
}
