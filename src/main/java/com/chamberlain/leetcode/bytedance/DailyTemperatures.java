package com.chamberlain.leetcode.bytedance;


import java.util.Stack;

/**
 * Created by chamberlain on 2021/4/17.
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures {

    /**
     * 暴力搜索
     */
    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i+1; j < T.length; j++) {
                result[i]+=1;
                if (T[j] > T[i]){
                    break;
                }
                if (j == T.length - 1){
                    result[i] = 0;
                }

            }

        }

        return result;

    }

    /**
     * 单调栈
     */
    public int[] dailyTemperatures1(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            while(stack.size() > 0 && T[stack.peek()] < T[i]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }



    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] array = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int i : dailyTemperatures.dailyTemperatures1(array)) {
            System.out.println(i);
        }

    }
}
