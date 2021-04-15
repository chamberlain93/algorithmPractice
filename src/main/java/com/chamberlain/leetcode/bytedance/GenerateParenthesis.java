package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/16.
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        dfs(result, "", n, 0);
        return result;

    }

    /**
     * left代表左边还剩多少,right代表右边能加多少
     */
    public void dfs(List<String> result, String str, int left, int right) {

        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) {
            dfs(result, str + "(", left - 1, right + 1);
        }
        if (right > 0) {
            dfs(result, str + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        for (String s : generateParenthesis.generateParenthesis(3)) {
            System.out.println(s);
        }
    }
}
