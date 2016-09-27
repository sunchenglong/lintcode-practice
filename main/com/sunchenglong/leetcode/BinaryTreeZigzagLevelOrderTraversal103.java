package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        treeNodes.add(root);
        int flag = 0;
        while (!treeNodes.isEmpty()) {
            List<Integer> integers = new ArrayList<Integer>();
            List<TreeNode> tmpTreeNodes = new ArrayList<TreeNode>();
            int length = treeNodes.size();
            if (flag % 2 == 0) {
                for (int i = 0; i < length; i++) {
                    if (treeNodes.get(i) != null) integers.add(treeNodes.get(i).val);
                }
            } else {
                for (int i = length - 1; i >= 0; i--) {
                    if (treeNodes.get(i) != null) integers.add(treeNodes.get(i).val);
                }
            }
            for (TreeNode treeNode : treeNodes) {
                if (treeNode != null) {
                    tmpTreeNodes.add(treeNode.left);
                    tmpTreeNodes.add(treeNode.right);
                }
            }
            treeNodes = tmpTreeNodes;
            if (!integers.isEmpty()) {
                result.add(integers);
            }
            flag ++;
        }
        return result;
    }
}
