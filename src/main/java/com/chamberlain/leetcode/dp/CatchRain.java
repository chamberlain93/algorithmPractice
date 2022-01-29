package com.chamberlain.leetcode.dp;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class CatchRain {

    public int trap(int[] height) {

        if (height == null || height.length <= 2){
            return 0;
        }

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }

        for (int i = height.length -2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }

        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        CatchRain catchRain = new CatchRain();
        System.out.println(catchRain.trap(height));
    }

}
