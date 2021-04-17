package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/17.
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null){
            return new ArrayList<>();
        }

        dfs(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int start, int target , int[] nums){

        if (target == 0){
            result.add(new ArrayList<>(element));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] <0){
                continue;
            }
            element.add(nums[i]);
            dfs(result, element, i, target- nums[i], nums);
            element.remove(element.size()-1);
        }

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {1,2,3};
        int target = 7;
        System.out.println(combinationSum.combinationSum(nums, target));
    }
}
