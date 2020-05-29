package com.chamberlain.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * 解题思路：寻找字符串中最长的不重复子串,时间复杂度O(n2)
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null||"".equals(s)) {
            return 0;
        }

        int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int temp = 1;
            String str = s.substring(i, i + 1);
            for (int j = i + 1; j < s.length(); j++) {
                if (!str.contains(s.substring(j, j + 1))) {
                    temp += 1;
                    str += s.substring(j, j + 1);
                } else {
                    break;
                }
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }


    /**
     * 通过滑窗，copy for leetcode
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBySlidingWin(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 通过ascii，copy for leetcode
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringByASCII(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character记录了当前字符在字符串中的位置
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);//i直接从重复的地方开始
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;//记录当前字符的位置
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(""));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstringBySlidingWin("abcadcca"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstringByASCII("abcadcca"));
    }
}
