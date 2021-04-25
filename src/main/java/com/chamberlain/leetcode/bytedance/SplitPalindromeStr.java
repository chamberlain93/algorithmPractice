package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class SplitPalindromeStr {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0);
        return result;
    }

    public void dfs(List<List<String>> result, List<String> subStrList, String s, int start){
        if(start == s.length()){
            result.add(new ArrayList<>(subStrList));
        }
        for (int i = start; i < s.length(); i++){
            String str = s.substring(start,i+1);
            if (!judgePalindrome(str)){
                continue;
            }
            subStrList.add(s.substring(start,i+1));
            dfs(result, subStrList, s, i+1);
            subStrList.remove(subStrList.size()-1);
        }
    }

    //判断回文数
    public boolean judgePalindrome(String str){

        int i =0;
        int j = str.length() -1;
        while(i<j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        SplitPalindromeStr splitPalindromeStr = new SplitPalindromeStr();
        splitPalindromeStr.partition("abcd");
    }
}
