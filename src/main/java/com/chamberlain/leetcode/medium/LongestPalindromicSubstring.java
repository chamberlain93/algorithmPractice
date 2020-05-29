package com.chamberlain.leetcode.medium;

/**
 * 最大回文子串
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {

    /**
     * 暴力搜素，超时
     *
     * @param s
     * @return
     */
    public String solve(String s) {
        if (s == null) {
            return null;
        }
        if ("".equals(s)) {
            return "";
        }
        int start = 0;
        int end = 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (judgePalindromicSubstring(s.substring(i, j + 1)) && (j + 1 - i) > max) {
                    start = i;
                    end = j;
                    max = j + 1 - i;
                    break;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public boolean judgePalindromicSubstring(String s) {
        if (s.length() == 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 动态规划 dp[i,j] = dp[i+1,j-1],str[i]=str[j]
     *
     * @param
     * @return
     */
    public String dp(String s) {

        if (s == null) {
            return null;
        }
        if ("".equals(s)) {
            return "";
        }
        int[][] dp = new int[s.length()][s.length()];
        int start = 0;
        int end = 0;
        //初始化状态
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i] = 1;
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                end = i + 1;


            }
        }
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (dp[j + 1][j + i - 2] == 1 && s.charAt(j) == s.charAt(j + i - 1)) {
                    dp[j][j + i - 1] = 1;
                    start = j;
                    end = j + i - 1;


                }

            }
        }

        return s.substring(start, end + 1);

    }

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(new LongestPalindromicSubstring().dp(s));
    }
}
