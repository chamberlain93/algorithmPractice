package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chamberlain on 2021/4/17.
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permute {

    public void trace(List<List<Integer>> result, int[] nums, List<Integer> element, int[] visit){
        if (nums.length == element.size()){
            List<Integer> item = new ArrayList<>(element);
            result.add(item);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1){
                continue;
            }
            element.add(nums[i]);
            visit[i] =1;
            trace(result,nums,element,visit);
            element.remove(element.size()-1);
            visit[i] = 0;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> element = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] visit = new int[20];
        trace(result,nums,element, visit);
        return result;

    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums={1,2,3};
        System.out.println(permute.permute(nums));
    }
}
