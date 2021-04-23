package com.chamberlain.leetcode.bytedance;

import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - temp) < Math.abs(target - result)) {
                    result = temp;
                }
                if (target - temp > 0) {
                    left++;
                } else if (target - temp < 0) {
                    right--;
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }
}
