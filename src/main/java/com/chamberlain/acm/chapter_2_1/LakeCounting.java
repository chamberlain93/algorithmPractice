package com.chamberlain.acm.chapter_2_1;

/**
 * Created by chamberlain on 2020/5/26.
 */
public class LakeCounting {




    public void dfs(char[][] grid, int i,int j){
        grid[i][j]='*';
        int x = grid.length;
        int y = grid[0].length;
        for (int ai=-1;ai<=1;ai++){
            for (int bi=-1;bi<=1;bi++){
                if (Math.abs(ai)==Math.abs(bi)){
                    continue;
                }
                int ci = i+ai;
                int cj = j+bi;
                if (ci<=x-1&&ci>=0&&cj<=y-1&&cj>=0&&grid[ci][cj]=='w'){
                    dfs(grid,ci,cj);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int result= 0;
        int x = grid.length;
        int y = grid[0].length;
        for (int i =0;i<x;i++){
            for (int j = 0;j<y;j++){
                if (grid[i][j]=='w'){
                    dfs(grid,i,j);
                    result++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args){
        char[][] grid = {
                {'w','w','*','*','*'},
                {'w','w','*','*','*'},
                {'*','*','w','*','*'},
                {'*','*','*','w','w'},
                };
        System.out.println(new LakeCounting().numIslands(grid));
    }
}
