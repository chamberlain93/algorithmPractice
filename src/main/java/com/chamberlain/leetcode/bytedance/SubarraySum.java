package com.chamberlain.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chamberlain on 2021/4/19.
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
 */
public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum ==k){
                    result++;
                }
            }
        }
        return result;
    }

    //前缀和,采用累加的方式去滑窗
    public int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] nums = {1,-1,0};
        System.out.println(subArraySum.subarraySum(nums,0));
    }
}
