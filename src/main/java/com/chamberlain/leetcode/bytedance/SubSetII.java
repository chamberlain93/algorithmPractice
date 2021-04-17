package com.chamberlain.leetcode.bytedance;

import java.util.*;

/**
 * Created by chamberlain on 2021/2/28.给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class SubSetII {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null){
            return null;
        }
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), 0, nums);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int start, int[] nums) {

        result.add(new ArrayList<>(element));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            element.add(nums[i]);
            dfs(result, element, i + 1, nums);
            element.remove(element.size() - 1);
        }
    }


    public static void main(String[] args) {
        SubSetII subSetII = new SubSetII();
        int[] nums = {1, 1, 2, 2};
        for (List<Integer> list : subSetII.subsetsWithDup(nums)) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
}
