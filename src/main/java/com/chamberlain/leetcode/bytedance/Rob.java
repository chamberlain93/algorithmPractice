package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/19.
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
 */
public class Rob {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3){
            return Math.max(nums[1], nums[0]+nums[2]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(nums[1], nums[0]+nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-3]+nums[i-1]);
        }

        int ans = 0;
        for (int i : dp) {
           if (ans<i){
               ans = i;
           }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Rob rob = new Rob();
        System.out.println(rob.rob(nums));
    }
}
