package com.chamberlain.leetcode.bytedance;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = num.length();
        while (i < n) {
            Character c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                k--;
                stack.pop();
            }
            if (c != '0' || !stack.isEmpty()) {
                stack.add(c);
            }
            i++;
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        String str = "10001";
        int k = 4;
        System.out.println(removeKDigits.removeKdigits(str, k));
    }
}
