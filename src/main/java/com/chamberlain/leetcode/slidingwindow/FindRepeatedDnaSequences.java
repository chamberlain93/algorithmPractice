package com.chamberlain.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DNA序列由一系列核苷酸组成，缩写为'A','C','G'和'T'.。
 *
 * 例如，"ACGAATTCCG"是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 *
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的长度为10的序列(子字符串)。你可以按 任意顺序 返回答案。
 *
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 */
public class FindRepeatedDnaSequences {

    /**
     * 暴力超时
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int i = 0, j = 9;
        int m = 0, n = 9;
        while (j < s.length()){
            String tempStr = s.substring(i, j+1);
            if (result.contains(tempStr)){
                i++;
                j++;
                continue;
            }
            while (n< s.length()){
                if (i != m && j != n && tempStr.equals(s.substring(m, n+1)) && !result.contains(tempStr)){
                    result.add(tempStr);
                    break;
                }
                m++;
                n++;
            }
            m=0;
            n=9;
            i++;
            j++;
        }


        return result;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        if (s == null || s.length() <= 10){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        Map<String, Integer> sequenceMap = new HashMap<>();
        int i = 0, j = 9;
        while (j < s.length()){
            String tempStr = s.substring(i, j+1);
            if (sequenceMap.containsKey(tempStr)){
                if (!result.contains(tempStr)){
                    result.add(tempStr);
                }
            }else {
                sequenceMap.put(tempStr, 1);
            }
            i++;
            j++;
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        FindRepeatedDnaSequences findRepeatedDnaSequences = new FindRepeatedDnaSequences();
        for (String item : findRepeatedDnaSequences.findRepeatedDnaSequences2(s)) {
            System.out.println(item);
        }
    }
}
