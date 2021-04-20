package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/20.
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    //dfs 时间超过了限制
    public boolean dfs(int[] nums, int start, int target) {

        if (target <= 0 && start >= nums.length - 1) {
            return true;
        }


        if (nums[start] == 0) {
            return false;
        }
        for (int j = nums[start]; j >= 1; j--) {
            if (dfs(nums, start + j, target - j)) {
                return true;
            }
        }

        return false;
    }

    //贪心
    public boolean greedy(int[] nums) {
        int max = 0;
        int i =0;
        for (i = 0; i < nums.length; i++) {
            //说明前面最大跳数跨越不了0的鸿沟
            if(max < i){
                return false;
            }

            max = Math.max(max, i + nums[i]);

        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.greedy(nums));
    }
}
