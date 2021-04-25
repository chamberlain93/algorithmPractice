package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/24.
 *  最长重复子数组
 *  给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class LongestCommonSubArray {

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    dp[i+1][j+1] = dp[i][j] +1;
                    result = Math.max(dp[i+1][j+1],result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,2,1};
        int[] num2 = {3,2,1,4,7};
        LongestCommonSubArray longestCommonSubArray = new LongestCommonSubArray();
        System.out.println(longestCommonSubArray.findLength(num1,num2));
    }
}
