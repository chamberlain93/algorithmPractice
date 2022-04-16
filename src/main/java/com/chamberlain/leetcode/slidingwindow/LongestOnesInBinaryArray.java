package com.chamberlain.leetcode.slidingwindow;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class LongestOnesInBinaryArray {

    public int longestOnes(int[] nums, int k) {
        if (nums == null){
            return 0;
        }
        int i = 0 , j = 0 , zeroNum = 0;
        int max = Integer.MIN_VALUE;
        while (j < nums.length){
            if (nums[j] == 0){
                zeroNum ++;
            }
            while (zeroNum > k){
                if (nums[i] == 0){
                    zeroNum --;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max == Integer.MIN_VALUE ? nums.length: max;
    }

    public static void main(String[] args) {
        LongestOnesInBinaryArray longestOnesInBinaryArray = new LongestOnesInBinaryArray();
        int[] nums = {1,1,1,0,0,0};
        int k = 2;
        System.out.println(longestOnesInBinaryArray.longestOnes(nums, k));
    }
}
