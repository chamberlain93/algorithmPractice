package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/3/5.
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：每行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数。
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            int[] element = matrix[i];
            if (target < element[0]) {
                return false;
            }

            if (target > element[element.length - 1]) {
                continue;
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

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix,target));
    }

}
