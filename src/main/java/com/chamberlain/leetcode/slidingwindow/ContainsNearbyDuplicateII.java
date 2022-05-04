package com.chamberlain.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 */
public class ContainsNearbyDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }

        int j = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
         while (j < nums.length){
             if (!map.containsKey(nums[j])){
                 map.put(nums[j], j);
             }else {
                 if (Math.abs(map.get(nums[j]) -j) <= k ){
                     return true;
                 }else {
                     map.put(nums[j], j);
                 }
             }
             j++;
         }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicateII containsNearbyDuplicateII = new ContainsNearbyDuplicateII();
        int[] nums = {1,0,1,1};
        System.out.println(containsNearbyDuplicateII.containsNearbyDuplicate(nums, 3));
    }
}
