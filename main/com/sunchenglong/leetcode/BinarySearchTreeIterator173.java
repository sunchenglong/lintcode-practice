package com.sunchenglong.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class BinarySearchTreeIterator173 {
}

class BSTIterator {
    private List<Integer> queue = null;
    private Iterator<Integer> iterator = null;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<Integer>();
        dfs(root);
        iterator = queue.iterator();
    }

    public void dfs(TreeNode treeNode) {
        if (treeNode != null) {
            dfs(treeNode.left);
            queue.add(treeNode.val);
            dfs(treeNode.right);
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next();
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */