package com.chamberlain.leetcode.dfs;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedArea {

    public void solve(char[][] board) {

        if (board == null || board.length == 0){
            return;
        }
        //找出所有没有被包围的O(边界O和与边界O相邻的O)，将他们替换为Z
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0  || i == board.length-1 || j == 0  || j == board[0].length -1) && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }

        //将所有的Z替换为O，将所有的O替换为X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Z'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }


    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'Z') {
            return;
        }
        board[i][j] = 'Z';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedArea surroundedArea = new SurroundedArea();
        surroundedArea.solve(board);
    }
}
