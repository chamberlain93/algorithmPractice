package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/17.
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列
 */
public class PermuteII {

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> element, int[] visit){
        if (nums.length == element.size()){
            List<Integer> item = new ArrayList<>(element);
            result.add(item);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1){
                continue;
            }
            if (i > 0 && visit[i-1] == 0 && nums[i] == nums[i-1] ){
                continue;
            }
            element.add(nums[i]);
            visit[i] =1;
            dfs(result,nums,element,visit);
            element.remove(element.size()-1);
            visit[i] = 0;
        }
    }

    public List<List<Integer>> permuteII(int[] nums) {
        List<Integer> element = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] visit = new int[20];
        Arrays.sort(nums);
        dfs(result,nums,element, visit);
        return result;

    }

    public static void main(String[] args) {
        PermuteII permuteII = new PermuteII();
        int[] nums={1,2,2};
        System.out.println(permuteII.permuteII(nums));
    }
}
