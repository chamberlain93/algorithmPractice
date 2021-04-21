package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class PermuteOfStr {

    public String[] permutation(String s) {
        List<String> temp = new ArrayList<>();
        int[] visit = new int[s.length()];
        char[] array = s.toCharArray();
        Arrays.sort(array);
        s = new String(array);
        dfs(temp, s, "", visit);
        String[] result = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    public void dfs(List<String> result, String s, String permutation, int[] visit){
        if (permutation.length() == s.length()){
            result.add(permutation);
            return;
        }
        StringBuilder permutationBuilder = new StringBuilder(permutation);
        for (int i = 0; i<s.length(); i++){
            if (visit[i] == 1){
                continue;
            }
            if (i > 0 && visit[i-1] == 0 && s.charAt(i) == s.charAt(i-1)){
                continue;
            }
            permutationBuilder.append(s.charAt(i));
            visit[i] = 1;
            dfs(result, s, permutationBuilder.toString(), visit);
            visit[i]= 0;
            permutationBuilder.deleteCharAt(permutationBuilder.length()-1);
        }

    }

    public static void main(String[] args) {
        PermuteOfStr permuteOfStr = new PermuteOfStr();
        String str = "aac";
        for (String s : permuteOfStr.permutation(str)) {
            System.out.println(s);
        }
    }
}
