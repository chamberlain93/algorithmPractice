package com.chamberlain.leetcode.medium;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    //dp 状态方程 dp[i] = dp[i-1]+dp[i-2]  when s.subString(i-1,i+1)<26
    public static int numDecodings(String s) {
        if (s.length() == 1) {
            if (s.charAt(0)>'0')return 1;
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0, 2)) <= 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i-1)>'0'&&Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("22623"));
    }
}
