package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/24.
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            newNums[i+1] = nums[i];
        }
        newNums[newNums.length-1] = Integer.MIN_VALUE;
        for (int i = 0; i < newNums.length-1; i++) {
            if (newNums[i] > newNums[i+1]){
                return i-1;
            }
        }
        return 0;
    }

    public int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(nums));
    }

}
