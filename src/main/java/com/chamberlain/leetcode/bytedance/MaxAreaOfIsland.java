package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/18.
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> areaList = new ArrayList<>();
                    areaList.add(1);
                    grid[i][j] = 0;
                    dfs(grid, i, j, areaList);
                    if (areaList.size() > max) {
                        max = areaList.size();
                    }
                }
            }
        }


        return max;
    }

    public void dfs(int[][] grid, int i, int j,List<Integer> areaList) {

        for (int m = -1; m <= 1; m++) {
            for (int n = -1; n <= 1; n++) {
                if (i + m >= 0 && i + m < grid.length && j + n >= 0 && j + n < grid[0].length
                        && m * n == 0 && grid[i + m][j + n] == 1) {
                    grid[i+m][j+n]= 0;
                    areaList.add(1);
                    dfs(grid, i + m, j + n, areaList);
                }
            }
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid =
                {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }
}
