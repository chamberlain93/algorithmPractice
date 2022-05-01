package com.chamberlain.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * <p>
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 */
public class LongestCharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0, historyCharMax = 0;
        int max=0;
        int[] map = new int[26];
        while (j < s.length()) {
            map[s.charAt(j) - 'A'] ++;
            historyCharMax = Math.max(historyCharMax, map[s.charAt(j) - 'A']);
            if (j - i + 1 -historyCharMax > k){
                map[s.charAt(j) - 'A'] --;
                i++;
            }else {
                max = Math.max(max, j - i + 1);
            }
            j++;


        }
        return max;
    }

    public static void main(String[] args) {
        LongestCharacterReplacement longestCharacterReplacement = new LongestCharacterReplacement();
        System.out.println(longestCharacterReplacement.characterReplacement("AABABBA", 1));
    }

}
