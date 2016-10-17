package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */
public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        if (grid.length <= 0) return 0;
        int xLength = grid.length;
        int yLength = grid[0].length;
        if (yLength <= 0) return 0;
        int[][] f = new int[xLength][yLength];
        f[0][0] = grid[0][0];
        for (int i = 1; i < xLength; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < yLength; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < xLength; i++)
            for (int j = 1; j < yLength; j++) {
                f[i][j] = Math.min(f[i - 1][j] + grid[i][j], f[i][j - 1] + grid[i][j]);
            }
        return f[xLength - 1][yLength - 1];
    }
}
