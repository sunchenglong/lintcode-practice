package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class PopulatingNextRight116 {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> queue = new ArrayList<>();
        if (root == null) return;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode firstNode = null;
            List<TreeLinkNode> tmpList = new ArrayList<>();
            for (TreeLinkNode tmp : queue) {
                if (firstNode == null) {
                    firstNode = tmp;
                } else {
                    firstNode.next = tmp;
                    firstNode = tmp;
                }
                if (tmp.left != null)
                    tmpList.add(tmp.left);
                if (tmp.right != null)
                    tmpList.add(tmp.right);
            }
            firstNode.next = null;
            queue = tmpList;
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}