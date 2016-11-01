package com.sunchenglong.leetcode;

import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/11/1.
 */
public class LargestRectangleinHistogram84 {
    /**
     * 从左到右维护一个递增的栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == length ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                int trace = heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleinHistogram84().largestRectangleArea(new int[]{2, 7, 5, 6, 4}));
    }
}
