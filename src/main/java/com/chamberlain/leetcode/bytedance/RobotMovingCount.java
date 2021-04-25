package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/22.
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 */
public class RobotMovingCount {

    int result = 0;

    public int movingCount(int m, int n, int k) {
        if (k==0){
            return 1;
        }

        boolean[][] visit = new boolean[m][n];
        dfs(m, n, 0, 0, k, visit);

        return result;
    }

    public void dfs(int m, int n, int i, int j, int k, boolean[][] visit) {
        int x = m;
        int y = n;
        for (int ai = -1; ai <= 1; ai++) {
            for (int bi = -1; bi <= 1; bi++) {
                if (Math.abs(ai) == Math.abs(bi)) {
                    continue;
                }
                int ci = i + ai;
                int cj = j + bi;
                if (ci <= x - 1 && ci >= 0 && cj <= y - 1 && cj >= 0 && !visit[ci][cj] && (judgeSum(ci) + judgeSum(cj)) <= k ) {
                    result++;
                    visit[ci][cj] = true;
                    dfs(m, n, ci, cj, k, visit);
                }
            }
        }
    }

    int judgeSum(int i) {
        int sum = 0, num = i;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotMovingCount robotMovingCount = new RobotMovingCount();
        System.out.println(robotMovingCount.movingCount(3,1,0));
    }


}
