package com.chamberlain.leetcode.bytedance.dp;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length ==0){
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i][j])) + 1;
                    max = Math.max(dp[i + 1][j + 1], max);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        //char[][] matrix = {{'0','1'}};
        System.out.println(maximalSquare.maximalSquare(matrix));
    }
}
