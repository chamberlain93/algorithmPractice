package com.chamberlain.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int i = 0, j = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()){
            while (map.containsKey(s.charAt(j))){
                map.remove(s.charAt(i));
                i++;
            }
            map.putIfAbsent(s.charAt(j), 1);
            max = Math.max(max, j-i+1);
            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
