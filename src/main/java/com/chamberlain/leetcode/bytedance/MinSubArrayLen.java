package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/25.
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
public class MinSubArrayLen {

    /**
     * 双指针滑窗
     */
    public int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            while (target > 0 && j < nums.length) {
                target = target - nums[j];
                if (target >0){
                    j++;
                }

            }
            if (target <= 0){
                result = Math.min(result, j - i + 1);
                target = target + nums[i];
                if (target > 0){
                    j++;
                }
            }

        }
        return result == Integer.MAX_VALUE? 0 :result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
    }


}
