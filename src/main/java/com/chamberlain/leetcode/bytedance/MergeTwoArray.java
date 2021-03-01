package com.chamberlain.leetcode.bytedance;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class MergeTwoArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] result = new int[m+n];
        if (m == 0){
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        if (n==0){
            return;
        }
        while (i <m && j<n){
            if (nums1[i]<=nums2[j]){
                result[i+j] = nums1[i];
                i++;
            }else {
                result[i+j] = nums2[j];
                j++;
            }
        }

        if (i >= m){
            if (n - j >= 0) System.arraycopy(nums2, j, result, j + i, n - j);
        }

        if (j >= n){
            if (m - i >= 0) System.arraycopy(nums1, i, result, i + j, m - i);
        }

        System.arraycopy(result, 0, nums1, 0, result.length);

    }

    public static void main(String[] args) {
        int[] num1 = {0};
        int m=0;
        int[] num2 = {1};
        int n=1;
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        mergeTwoArray.merge(num1,m,num2,n);
        for (int i : num1) {
            System.out.print(i + " ");
        }
    }
}
