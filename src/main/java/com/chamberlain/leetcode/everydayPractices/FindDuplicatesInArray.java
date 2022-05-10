package com.chamberlain.leetcode.everydayPractices;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 */
public class FindDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0){
                result.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDuplicatesInArray findDuplicatesInArray = new FindDuplicatesInArray();
        System.out.println(findDuplicatesInArray.findDuplicates(nums).toArray().toString());
    }
}
