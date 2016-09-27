package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/9/26.
 */
public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> nodeQueue = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            List<TreeNode> tmpNodeQueue = new ArrayList<TreeNode>();
            for (TreeNode treeNode : nodeQueue) {
                if (treeNode != null) {
                    tmp.add(treeNode.val);
                    tmpNodeQueue.add(treeNode.left);
                    tmpNodeQueue.add(treeNode.right);
                }
            }
            if (!tmp.isEmpty()) {
                result.add(tmp);
            }
            nodeQueue = tmpNodeQueue;
        }
        return result;
    }

}
