package com.sunchenglong.leetcode;

import java.lang.Integer;

import static java.lang.Integer.max;

/**
 * Created by Administrator on 2016/8/8.
 */
public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int maxProfit = 0;
        int lowPrices = prices[0];
        for (int i = 0; i < length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - lowPrices);
            lowPrices = Math.min(lowPrices, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimetoBuyandSellStock121().maxProfit(new int[]{7, 6, 5}));
        System.out.println(new BestTimetoBuyandSellStock121().maxProfit(new int[]{7}));
    }
}
