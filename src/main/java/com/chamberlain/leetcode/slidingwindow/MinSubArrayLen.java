package com.chamberlain.leetcode.slidingwindow;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 链接：https://leetcode.cn/problems/2VG8Kg
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j];
            while (sum >= target && i<= j){
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};

        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
    }
}
