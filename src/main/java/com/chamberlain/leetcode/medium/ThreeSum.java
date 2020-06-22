package com.chamberlain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {


    /**
     * 先求两个数之和，再求三个
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int[][] twoSum = new int[nums.length][nums.length];
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (i!=j){
                    twoSum[i][j] = nums[i]+nums[j];
                }
            }
        }


        return new ArrayList<>();
    }
}
