package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class ConvertSortedArray108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length <= 0) return null;
        return sortedArrayToBST(nums, 0, length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode result = new TreeNode(nums[mid]);
            result.left = sortedArrayToBST(nums, left, mid - 1);
            result.right = sortedArrayToBST(nums, mid + 1, right);
            return result;
        } else {
            return null;
        }
    }
}
