package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/20.
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

 */
public class SearchMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            int[] element = matrix[i];
            if (target < element[0]) {
                return false;
            }

            //二分查找
            int m = 0;
            int n = element.length -1;
            while(m <= n){
                int middle = element[(m+n)/2];
                if (target > middle){
                    m = (m+n)/2 +1;
                }else if (target<middle){
                    n = (m+n)/2 -1;
                }else {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean searchMatrixII(int[][] matrix, int target){
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        SearchMatrixII searchMatrix = new SearchMatrixII();
        System.out.println(searchMatrix.searchMatrix(matrix,target));
    }
}
