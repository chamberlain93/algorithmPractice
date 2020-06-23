package com.chamberlain.leetcode.medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 *
 * 动态规划 状态转移方程 dp[i][j] = dp[i-1][j]+dp[i][j-1]
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (m<1||n<1||m>100||n>100){
            return 0;
        }
        int[][] dp = new  int[m][n];
        dp[0][0] = 0;
        for (int i = 0;i<n;i++){
            dp[0][i] = 1;
        }
        for (int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){

                    dp[i][j] = dp[i][j-1]+dp[i-1][j];

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args){
    }
}
