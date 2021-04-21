package com.chamberlain.leetcode.bytedance;

/**
 * Created by chamberlain on 2021/4/21.
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {

        char[] array = s.toCharArray();
        int i = 0;
        int j = 0;
        int[] count = new int[26];
        int max = 0;
        while (j < array.length) {
            count[array[j] - 'A'] += 1;
            if (max < count[array[j] - 'A']) {
                max = count[array[j] - 'A'];
            }

            if (j - i + 1 <= max + k) {
                j++;
            } else {
                count[array[i] - 'A'] -= 1;
                i++;
                j++;
            }


        }
        return array.length - i;
    }

    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        int k = 1;
        String str = "AABABBA";
        System.out.println(characterReplacement.characterReplacement(str, k));
    }


}
