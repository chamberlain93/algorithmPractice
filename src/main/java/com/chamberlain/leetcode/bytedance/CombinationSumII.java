package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null) {
            return new ArrayList<>();
        }
        int[] visit = new int[candidates.length];
        Arrays.sort(candidates);
        dfs(result, new ArrayList<>(), visit, 0, target, candidates);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int[] visit, int start, int target, int[] nums) {

        if (target == 0) {
            result.add(new ArrayList<>(element));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0 || visit[i] == 1) {
                continue;
            }
            if (i >= 1 && visit[i - 1] == 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            element.add(nums[i]);
            visit[i] = 1;
            dfs(result, element, visit, i + 1, target - nums[i], nums);
            element.remove(element.size() - 1);
            visit[i] = 0;
        }

    }

    public static void main(String[] args) {
        CombinationSumII combinationSum = new CombinationSumII();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum.combinationSum2(nums, target));
    }
}
