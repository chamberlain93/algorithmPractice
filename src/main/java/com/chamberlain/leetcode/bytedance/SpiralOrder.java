package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/18.
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 解题思路，寻找最近没有被访问的元素
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        trace(matrix, result);
        return result;

    }

    public void trace(int[][] matrix, List<Integer> result){

        for (int i : matrix[0]) {
            result.add(i);
        }
        if (matrix.length > 1){
            //去除第一行
            int[][] newMetrix = new int[matrix.length-1][];
            for (int i = 1; i < matrix.length; i++) {
                newMetrix[i-1] = matrix[i];
            }

            trace(transpose(newMetrix), result);
        }

    }

    //矩阵转置
    public int[][] transpose(int[][] matrix){
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                result[j][i] = matrix[i][matrix[0].length -1 - j];
            }
        }

        return result;

    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralOrder.spiralOrder(matrix);
        for (Integer integer : result) {
            System.out.println(integer + " ");
        }
    }
}
