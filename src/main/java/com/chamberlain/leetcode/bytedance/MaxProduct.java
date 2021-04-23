package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/22.
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxTemp = 1;
        int minTemp = 1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = maxTemp;
                maxTemp = minTemp;
                minTemp = temp;
            }
            maxTemp = Math.max(maxTemp * nums[i], nums[i]);
            minTemp = Math.min(minTemp * nums[i], nums[i]);

            max = Math.max(max, maxTemp);
        }

        return max;
    }
}
