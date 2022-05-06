package com.chamberlain.leetcode.slidingwindow;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (k == 0){
            return 0;
        }

        int count = 0, i=0, j=0;
        int multiply = 1;
        while (j < nums.length){
            multiply *= nums[j];
            while (multiply >= k && i <= j){
                multiply /= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
        int[] nums = {1,1,1};
        System.out.println(numSubarrayProductLessThanK.numSubarrayProductLessThanK(nums, 1));
    }
}
