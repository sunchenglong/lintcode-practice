package com.sunchenglong.leetcode;

import java.util.*;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class BinaryTreeLevelOrderTraversalII107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> tmpArray = new ArrayList<Integer>();
            List<TreeNode> tmpTreeNodes = new ArrayList<TreeNode>();
            for (TreeNode treeNode : treeNodes) {
                if (treeNode != null) {
                    tmpArray.add(treeNode.val);
                    tmpTreeNodes.add(treeNode.left);
                    tmpTreeNodes.add(treeNode.right);
                }
            }
            treeNodes = tmpTreeNodes;
            if (!tmpArray.isEmpty()) result.add(tmpArray);
        }
        Collections.reverse(result);
        return result;
    }
}
