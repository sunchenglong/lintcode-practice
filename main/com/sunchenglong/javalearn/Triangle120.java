package com.sunchenglong.javalearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/13.
 */
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] c = new int[height][height];
        if (height == 0) return 0;
        c[0][0] = triangle.get(0).get(0);
        int min = c[0][0];
        for (int i = 1; i < height; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                c[i][j] = Math.min(c[i - 1][j == i ? i - 1 : j], c[i - 1][j - 1 < 0 ? 0 : j - 1]) + triangle.get(i).get(j);
                min = Math.min(c[i][j], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> t1 = Arrays.asList(-1);
        List<Integer> t2 = Arrays.asList(2, 3);
        List<Integer> t3 = Arrays.asList(1, -1, -3);
        triangle.add(t1);
        triangle.add(t2);
        triangle.add(t3);
        System.out.println(new Triangle120().minimumTotal(triangle));

    }
}
