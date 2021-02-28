package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/2/22.
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列,解题思路回溯法
 */
public class AllArray {

    List<List<Integer>> result = new ArrayList<>();
    int[] visit = new int[20];

    public void trace(int[] nums, List<Integer> element){
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
            visit[i] = 1;
            trace(nums,element);
            element.remove(element.size()-1);
            visit[i]=0;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> element = new ArrayList<>();
        trace(nums,element);
        return result;

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        AllArray test = new AllArray();
        for (List<Integer> list : test.permute(nums)) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
