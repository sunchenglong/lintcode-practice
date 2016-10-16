package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/16.
 */
public class BestTimetoBuyandSellStockII122 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int result = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] < prices[i - 1]) {
                result = result + max - min;
                min = prices[i];
                max = prices[i];
            } else {
                max = prices[i];
                if (i == length - 1) {
                    result = result + max - min;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStockII122().maxProfit(new int[]{1, 4, 2}));
    }
}
