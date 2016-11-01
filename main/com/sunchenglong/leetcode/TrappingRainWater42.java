package com.sunchenglong.leetcode;

import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/11/1.
 */
public class TrappingRainWater42 {
    public int trap(int[] height) {
        if (height == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int bot = stack.pop();
                maxBotWater = stack.isEmpty() ? 0 : ((Math.min(height[i], height[stack.peek()]) - height[bot]) * (i - stack.peek() - 1));
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
}
