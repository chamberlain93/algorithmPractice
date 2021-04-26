package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/24.
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 链接：https://leetcode-cn.com/problems/4sum
 */
public class FourNumSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int[] visit = new int[nums.length];
        dfs(result, new ArrayList<>(), nums, visit, 0, target);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> numList, int[] nums, int[] visit, int start, int target) {
        if (target == 0 && numList.size() == 4) {
            result.add(new ArrayList<>(numList));
            return;
        }
        if (numList.size() > 4) {
            return;
        }


        for (int i = start; i < nums.length; i++) {
            if ((i >= 1 && visit[i - 1] == 0 && nums[i] == nums[i - 1])) {
                continue;
            }

            if (nums.length - i + numList.size() < 4){
                continue;
            }

            if ((target > 0 && (nums[nums.length - 1] * (4 - numList.size()) < target))
                    || (target < 0 && i < nums.length&& (nums[i] * (4 - numList.size()) > target))) {
                continue;
            }
            visit[i] = 1;
            numList.add(nums[i]);
            dfs(result, numList, nums, visit, i + 1, target - nums[i]);
            visit[i] = 0;
            numList.remove(numList.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        FourNumSum fourNumSum = new FourNumSum();
        System.out.println(fourNumSum.fourSum(nums, target));

    }
}
