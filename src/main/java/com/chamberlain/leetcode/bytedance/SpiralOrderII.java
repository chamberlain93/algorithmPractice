package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/25.
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 */
public class SpiralOrderII {

    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++;
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {
        SpiralOrderII spiralOrderII = new SpiralOrderII();
        int[][] result = spiralOrderII.generateMatrix(4);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
