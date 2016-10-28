package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/28.
 */
public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) return 0;
        int[] f = new int[obstacleGrid[0].length];
        f[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                f[j] = obstacleGrid[i][j] == 0 ? (j == 0 ? 0 : f[j - 1]) + f[j] : 0;
            }
        }
        return f[f.length - 1];
    }
}
