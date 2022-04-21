package com.chamberlain.leetcode.slidingwindow;

/**
 * 给你一个二进制数组nums，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 * 链接：https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element
 */
public class LongestSubarrayAfterDeleteOne {
    /**
     * 解题思路，滑动窗口中最多包含1个0
     */

    public int longestSubarray(int[] nums) {
        if (nums == null){
            return 0;
        }

        int left = 0, right= 0, zeroNum = 0;
        int max = Integer.MIN_VALUE;
        while (right <nums.length){
            if (nums[right] == 0){
                zeroNum ++;
            }
            while (zeroNum > 1){
                if (nums[left] == 0){
                    zeroNum --;
                }
                left ++;
            }
            max = Math.max(max, right - left + 1);
            right ++;
        }
        return max == nums.length ? max -1 : max;
    }

    public static void main(String[] args) {
        LongestSubarrayAfterDeleteOne longestSubarrayAfterDeleteOne = new LongestSubarrayAfterDeleteOne();
        int[] nums = {1,1,1,0,0,0};
        int k = 2;
        System.out.println(longestSubarrayAfterDeleteOne.longestSubarray(nums));
    }
}
