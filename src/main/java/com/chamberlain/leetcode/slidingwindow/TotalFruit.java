package com.chamberlain.leetcode.slidingwindow;

import java.util.*;

/**
 * 水果成篮 https://leetcode.cn/problems/fruit-into-baskets/
 *
 * 解题思路：滑动窗口找到最长的包含两种元素的子数组
 */
public class TotalFruit {

    /**
     * map效率比较低，改用list试试
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        while(j < fruits.length){
            if (!fruitMap.containsKey(fruits[j])){
                fruitMap.put(fruits[j], 1);
            }else {
                fruitMap.put(fruits[j], fruitMap.get(fruits[j])+ 1);
            }
            while(fruitMap.size() > 2){
                fruitMap.put(fruits[i], fruitMap.get(fruits[i]) - 1);
                if (fruitMap.get(fruits[i]) == 0){
                    fruitMap.remove(fruits[i]);
                }
                i++;
            }
            j++;
            max = Math.max(max, j - i);
        }
        return max;
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit.totalFruit(fruits));
    }
}
