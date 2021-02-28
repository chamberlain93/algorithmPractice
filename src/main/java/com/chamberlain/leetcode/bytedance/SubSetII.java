package com.chamberlain.leetcode.bytedance;

import java.util.*;

/**
 * Created by chamberlain on 2021/2/28.给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 */
public class SubSetII {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tempResult = trace(i, nums);
            for (List<Integer> list : tempResult) {
                if (!judgeRepeat(result, list)) {
                    result.add(list);
                }
            }
        }
        return result;
    }

    public boolean judgeRepeat(List<List<Integer>> result, List<Integer> element) {

        for (List<Integer> list : result) {
            if (judgeListEqual(list, element)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeListEqual(List<Integer> list1, List<Integer> list2) {

        Map<Integer, Integer> list1Map = new HashMap<>();
        for (Integer integer : list1) {
            list1Map.put(integer, list1Map.get(integer) == null ? 1 : list1Map.get(integer) + 1);
        }

        Map<Integer, Integer> list2Map = new HashMap<>();
        for (Integer integer : list2) {
            list2Map.put(integer, list2Map.get(integer) == null ? 1 : list2Map.get(integer) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : list1Map.entrySet()) {
            if (list2Map.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }

        for (Map.Entry<Integer, Integer> entry : list2Map.entrySet()) {
            if (list1Map.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }

        return true;
    }


    public List<List<Integer>> trace(int order, int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (order == nums.length - 1) {
            List<Integer> element = new ArrayList<>();
            element.add(nums[order]);
            result.add(element);
            return result;
        }

        result = trace(1 + order, nums);
        List<List<Integer>> tempResult = new ArrayList<>();
        for (List<Integer> list : result) {
            List<Integer> element = new ArrayList<>();
            for (Integer integer : list) {
                element.add(integer);
            }
            tempResult.add(element);
        }
        for (List<Integer> list : tempResult) {
            list.add(nums[order]);
        }

        for (List<Integer> list : tempResult) {
            if (!judgeRepeat(result, list)) {
                result.add(list);
            }
        }

        List<Integer> orderElement = new ArrayList<>();
        orderElement.add(nums[order]);
        if (!judgeRepeat(result, orderElement)) {
            result.add(orderElement);
        }
        return result;
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
