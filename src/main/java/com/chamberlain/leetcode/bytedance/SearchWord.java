package com.chamberlain.leetcode.bytedance;

import java.util.Arrays;

/**
 * Created by chamberlain on 2021/3/2.
 */
public class SearchWord {


    public boolean dfs(char[][] board, int i, int j, int wordIndex, String word) {
        board[i][j] = '0';
        int x = board.length;
        int y = board[0].length;
        if (wordIndex == word.length()) {
            return true;
        }
        for (int ai = -1; ai <= 1; ai++) {
            for (int bi = -1; bi <= 1; bi++) {
                if (Math.abs(ai) == Math.abs(bi)) {
                    continue;
                }
                int ci = i + ai;
                int cj = j + bi;
                if (ci <= x - 1 && ci >= 0 && cj <= y - 1 && cj >= 0 && board[ci][cj] == word.charAt(wordIndex)) {
                    wordIndex++;
                    if (dfs(board, ci, cj, wordIndex, word)) {
                        return true;
                    } else {
                        --wordIndex;
                    }
                }
            }
        }
        board[i][j] = word.charAt(wordIndex - 1);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char[][] temp = Arrays.copyOf(board, board.length);
                if (temp[i][j] == word.charAt(0) && dfs(temp, i, j, 1, word)) {
                    return true;
                }


            }
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board = {{'A'}};
        String word = "B";
        SearchWord searchWord = new SearchWord();
        System.out.println(searchWord.exist(board, word));
    }
}
