package com.chamberlain.leetcode.medium;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 *
 */
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        //长度为i的连续数字能组成的二叉树的数量
        int[] dp = new int[n+1];
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i= 3;i<=n;i++){
            for (int j = 1;j<=i;j++){
                //左边的二叉树个数乘以右边的个数,参数代表自然数的个数
                dp[i] += dp[j-1]*dp[i-j];
            }

        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(numTrees(3));
    }




}
