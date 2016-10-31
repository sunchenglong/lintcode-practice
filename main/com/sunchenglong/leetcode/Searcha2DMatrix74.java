package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class Searcha2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int x = matrix.length, y = matrix[0].length;
        int left = 0, right = x * y - 1;
        while (left < right) {
            int media = left + (right - left) / 2;
            if (matrix[media / y][media % y] == target)
                return true;
            else if (matrix[media / y][media % y] >= target)
                right = media;
            else
                left = media + 1;
        }
        return matrix[right / y][right % y] == target;
    }

    public static void main(String[] args) {
        System.out.println(new Searcha2DMatrix74().searchMatrix(new int[][]{new int[]{1, 1}}, 2));
    }

}
