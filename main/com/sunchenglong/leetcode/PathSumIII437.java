package com.sunchenglong.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class PathSumIII437 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null)
            return 0;
        sum += root.val;
        int result = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        result += helper(root.left, sum, target, preSum) + helper(root.right, sum, target, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.getOrDefault(1, 0));
    }
}
