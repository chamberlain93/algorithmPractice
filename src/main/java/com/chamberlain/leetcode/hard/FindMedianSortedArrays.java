package com.chamberlain.leetcode.hard;

/**
 * Created by chamberlain on 2021/7/5.
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] num3 = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                num3[i+j] = nums1[i];
                i++;
            }else {
                num3[i+j] = nums2[j];
                j++;
            }

        }

        if (i == nums1.length){
            while(j < nums2.length){
                num3[i+j] = nums2[j];
                j++;
            }
        }

        if (j == nums2.length){
            while(i < nums1.length){
                num3[i+j] = nums1[i];
                i++;
            }
        }


        return num3.length%2 == 1 ? num3[num3.length/2] : (num3[num3.length/2] + num3[num3.length/2-1])*1.0/2.0 ;
    }

    public static void main(String[] args) {
        int[] num1= {1,3,5,7,9};
        int[] num2 = {2,4,6,8,10};
        System.out.println(findMedianSortedArrays(num1,num2));
        ;
    }
}
