package com.chamberlain.leetcode.medium;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    /**
     * 暴力搜索
     * @param height
     * @return
     */
    private static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0;i<height.length;i++ ){
            for (int j = i+1; j<height.length;j++){
                max = Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;
    }

    /**
     * 双指针，初始化一个指针在数组左边，一个在右边，向中间移动，移动的规则就是移动指向数字较小的指针，这个的原理就是短板原理
     * @param height
     * @return
     */
    private static int maxArea2(int[] height) {

        int i=0,j=height.length-1;
        int max = 0;
        while (i<j){
            int temp = Math.min(height[i],height[j])*(j-i);
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
            if (temp>max){
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] input = {1 ,1 ,9 ,1};
        System.out.println(maxArea2(input));
    }
}
