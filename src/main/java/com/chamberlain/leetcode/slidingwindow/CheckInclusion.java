package com.chamberlain.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null){
            return false;
        }
        s1 = s1.trim();
        s2 = s2.trim();
        if (s1.length() > s2.length()){
            return false;
        }
        int[] nums = new int[26];
        for (int n = 0; n < s1.length(); n++){
            nums[s1.charAt(n) - 'a'] ++;
        }
        int i = 0, j = s1.length() - 1;
        while (j < s2.length()){
            int[] tempNums = Arrays.copyOf(nums, nums.length);
            int count = s1.length();
            for (int m = i; m <= j; m++){
                if (tempNums[s2.charAt(m) - 'a'] == 0){
                    break;
                }else {
                    tempNums[s2.charAt(m) - 'a'] --;
                    count --;
                }
            }
            if (count == 0){
                return true;
            }
            i++;
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("abc","ccccbbbbaaaa"));
    }

}
