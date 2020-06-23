package com.chamberlain.leetcode.medium;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class ClimbingStairs {

    //dp
    public static int climbStairs(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] =1;
        dp[1]=2;
        for (int i = 2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n-1];
    }

    //递归
    public static int climbStairs1(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    public static void main(String[] args){
        //System.out.println(climbStairs(1));
        System.out.println(climbStairs1(4));
    }
}
