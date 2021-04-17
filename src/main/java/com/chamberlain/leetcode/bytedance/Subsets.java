package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/17.
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }

        dfs(result, new ArrayList<>(), 0,  nums);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> ans, int start, int[] nums ){
        result.add(new ArrayList<>(ans));
        for (int i = start; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(result, ans, i + 1, nums);
            ans.remove(ans.size()-1);
        }
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3,4};
        System.out.println(subsets.subsets(nums));
    }
}
