package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/24.
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 */
public class FindDuplicateNum {

    public int findDuplicate(int[] nums) {

        quicksort(nums, 0, nums.length - 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public void quicksort(int[] nums, int start, int end) {

        if (start < end) {
            int i = partition(nums, start, end);
            quicksort(nums, start, i - 1);
            quicksort(nums, i + 1, end);
        }

    }

    public int partition(int[] nums, int start, int end) {

        int ans = nums[start];
        int i = start;
        while (start != end) {

            while (ans <= nums[end] && start < end) {
                end--;
            }

            while (ans >= nums[start] && start < end) {
                start++;
            }


            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }

        }

        int temp = ans;
        nums[i] = nums[start];
        nums[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        FindDuplicateNum findDuplicateNum = new FindDuplicateNum();
        System.out.println(findDuplicateNum.findDuplicate(nums));
    }
}
