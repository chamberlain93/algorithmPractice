package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/24.
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        int len = digits.length();
        for (int i = 0; i < str[digits.charAt(0) - '0' - 2].toCharArray().length; i++) {
            result.add(str[digits.charAt(0)- '0' - 2].toCharArray()[i] + "");
        }
        int i = 1;
        while (i < len) {
            List<String> tempList = result;
            result = new ArrayList<>();
            for (String s : tempList) {
                for (int j = 0; j < str[digits.charAt(i) - '0' - 2].toCharArray().length; j++) {
                    result.add(s + str[digits.charAt(i)- '0' - 2].toCharArray()[j]);
                }
            }

            i++;

        }
        return result;
    }

    public static void main(String[] args) {
        String str = "678";
        LetterCombinations letterCombinations = new LetterCombinations();
        int i = 1;
        for (String s : letterCombinations.letterCombinations(str)) {
            System.out.println(s + " " + i);
            i++;
        }
    }
}
