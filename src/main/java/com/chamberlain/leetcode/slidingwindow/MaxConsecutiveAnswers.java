package com.chamberlain.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 考试的最大困扰度
 * leetcode2024: https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/
 */
public class MaxConsecutiveAnswers {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey == null || answerKey.length() == 0){
            return 0;
        }
        int tNum = 0;
        int fNum = 0;
        int i=0;
        int j=0;
        int max = 0;
        while(j < answerKey.length()){
            if (answerKey.charAt(j) == 'T'){
                tNum++;
            }else {
                fNum++;
            }
            if (Math.min(tNum,fNum) > k){
                if (answerKey.charAt(i) == 'T'){
                    tNum--;
                }else {
                    fNum--;
                }
                i++;
            }else {
                max = tNum + fNum;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveAnswers maxConsecutiveAnswers = new MaxConsecutiveAnswers();
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("TFFT", 2));
    }
}
