package com.sunchenglong.javalearn;

import java.util.Arrays;

/**
 * Created by Chenglong Sun on 2016/10/18.
 */
public class QuickSort {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int q = partition(nums, left, right);
            quickSort(nums, left, q - 1);
            quickSort(nums, q + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 1, 2, 3};
        new QuickSort().quickSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
