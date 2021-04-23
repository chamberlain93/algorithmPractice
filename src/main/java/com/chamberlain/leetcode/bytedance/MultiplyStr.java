package com.chamberlain.leetcode.bytedance;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class MultiplyStr {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String[] tempResult = new String[num1.length()];
        char[] num1Array = num1.toCharArray();
        for (int i = num1Array.length - 1; i >= 0; i--) {
            tempResult[num1Array.length - 1 - i] = charMultiplyStr(num1Array[i], num2);
        }
        String sum = tempResult[0];
        for (int i = 1; i < tempResult.length; i++) {
            if ("".equals(tempResult[i])) {
                continue;
            }
            sum = sumOfStr(sum, tempResult[i], i);
        }
        return sum;
    }

    public String sumOfStr(String str1, String str2, int index) {
        //先给str2后面加index个0
        while (index > 0) {
            str2 += "0";
            index--;
        }

        int i = str1.length() - 1;
        int j = str2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int add = 0;
        while (i >= 0 || j >= 0) {
            int tempSum;
            if (i < 0) {
                tempSum = str2.charAt(j) - '0' + add;
            } else if (j < 0) {
                tempSum = str1.charAt(i) - '0' + add;
            } else {
                tempSum = (str1.charAt(i) - '0') + (str2.charAt(j) - '0') + add;

            }
            sb.append(tempSum % 10);
            add = tempSum / 10;
            i--;
            j--;
        }
        if (add > 0) {
            sb.append(add);
        }
        return sb.reverse().toString();

    }

    public String charMultiplyStr(char c, String s) {
        if (c == '0') {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int add = 0;
        while (i >= 0) {
            int temp = (c - '0') * (s.charAt(i) - '0') + add;
            sb.append(temp % 10);
            add = temp / 10;
            i--;
        }
        if (add > 0) {
            sb.append(add);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        MultiplyStr multiplyStr = new MultiplyStr();
        System.out.println(multiplyStr.multiply(num1, num2));
    }
}
