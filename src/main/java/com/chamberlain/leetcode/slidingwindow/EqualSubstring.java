package com.chamberlain.leetcode.slidingwindow;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s中的第i个字符变到t中的第 i 个字符需要|s[i] - t[i]|的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 */
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {

        if (s == null || s.length() == 0){
            return 0;
        }

        int i =0, j = 0;
        int max = 0;
        while (j < s.length()){
            maxCost -= Math.abs(t.charAt(j) -s.charAt(j));
            while (maxCost < 0){
                maxCost += Math.abs(t.charAt(i) - s.charAt(i));
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        EqualSubstring equalSubstring = new EqualSubstring();
        System.out.println(equalSubstring.equalSubstring("krrgw","zjxss", 19));
    }
}
