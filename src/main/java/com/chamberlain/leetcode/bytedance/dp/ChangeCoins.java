package com.chamberlain.leetcode.bytedance.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class ChangeCoins {

    int coinChange(List<Integer> coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (Integer coin : coins) {
            for (int i = coin; i< amount + 1; i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        if (dp[amount] != 10001){
            return dp[amount];
        }
        return -1;
    }

    int coinChange1(List<Integer> coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (Integer coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            } 
        }
        if (dp[amount] != 10001){
            return dp[amount];
        }
        return -1;
    }

    public static void main(String[] args) {
        ChangeCoins changeCoins = new ChangeCoins();
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        System.out.println(changeCoins.coinChange1(coins, 11));
    }
}
