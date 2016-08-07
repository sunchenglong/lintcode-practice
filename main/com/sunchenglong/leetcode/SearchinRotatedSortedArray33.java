package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/6.
 */
public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int media = 0;
        while (left <= right) {
            media = (left + right) / 2;
            if (nums[media] == target)
                return media;
            if (nums[left] <= nums[media]) {
                if (target >= nums[left] && target < nums[media]) {
                    right = media - 1;
                } else {
                    left = media + 1;
                }
            } else {
                if (target > nums[media] && target <= nums[right]) {
                    left = media + 1;
                } else {
                    right = media - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 0};
        System.out.println(new SearchinRotatedSortedArray33().search(a, 10));
        int b[] = {1, 3};
        System.out.println(new SearchinRotatedSortedArray33().search(b, 3));
    }
}
