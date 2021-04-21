package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/20.
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class JumpGameII {


    public int jump(int[] nums) {
        int cur = nums.length - 1;
        int result = 0;
        while (cur > 0) {
            for (int i = 0; i < cur; i++) {
                if (i + nums[i] >= cur) {
                    cur = i;
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGameII.jump(nums));
    }

}
