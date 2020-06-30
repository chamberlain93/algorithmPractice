package com.chamberlain.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {


    public static int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size()==0){
            return 0;
        }
        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = triangle.size() - 1;i >= 0;i--){
            for (int j = 0;j<triangle.get(i).size();j++){
                if (i== triangle.size()-1){
                    dp[i][j] = triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
                }

            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(triangle));
    }

}
