package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。

 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitWord {

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]==1 && wordDict.contains(s.substring(j,i))){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }

    public static void main(String[] args) {
        SplitWord splitWord = new SplitWord();
        String s = "applepenapple";
        List<String> wordList = new ArrayList<>();
        wordList.add("apple");
        wordList.add("pen");
        System.out.println(splitWord.wordBreak(s,wordList));
    }
}
