package com.sunchenglong.leetcode;

import java.util.Arrays;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class SearchforaRange34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftResult = left;
        int rightResult = right;
        while (left <= right) {
            int media = left + (right - left) / 2;
            if (nums[media] < target) left = media + 1;
            else if (nums[media] > target) right = media - 1;
            else {
                if (nums[left] == target && nums[right] == target) {
                    return new int[]{left, right};
                }
                if (nums[left] == target) leftResult = left;
                else left++;
                if (nums[right] == target) rightResult = right;
                else right--;

            }
            if(left == right && nums[right] != target) break;
        }
        if (nums[leftResult] == target) {
            if (nums[rightResult] == target) return new int[]{leftResult, rightResult};
            else if (nums[rightResult - 1] == target) return new int[]{leftResult, rightResult - 1};
        }
        if (nums[rightResult] == target) {
            if (nums[leftResult + 1] == target) return new int[]{leftResult + 1, rightResult};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchforaRange34().searchRange(new int[]{1, 2, 3}, 1)));
    }
}
