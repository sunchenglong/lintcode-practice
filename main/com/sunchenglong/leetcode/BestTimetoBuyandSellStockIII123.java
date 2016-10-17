package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/16.
 */
public class BestTimetoBuyandSellStockIII123 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int length = prices.length;
        if (length <= 1) return 0;
        int[] f = new int[length];
        int[] g = new int[length];
        int valley = prices[0];
        for (int i = 1; i < length; i++) {
            valley = Math.min(valley, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - valley);
        }
        int peek = prices[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            peek = Math.max(peek, prices[i]);
            g[i] = Math.max(g[i], peek - prices[i]);
        }
        for (int i = 0; i < length; i++) {
            result = Math.max(result, f[i] + g[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStockIII123().maxProfit(new int[]{1, 4, 2}));
    }
}

