package com.chamberlain.leetcode.bytedance;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class SearchRotateArray {

    public int search(int[] nums, int target) {
        if (nums[0] == target){
            return 0;
        }
        if (nums[nums.length -1] == target){
            return nums.length -1;
        }
        return BinarySearch(nums, 0, nums.length-1, target);
    }

    //变形的二分查找
    public int BinarySearch(int[] nums, int start, int end, int target){

        while (start <= end){
            int middle = (start+end)/2;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[middle] >= nums[start]){
                if (nums[start] <= target && target < nums[middle]){
                    end = middle -1;
                }else {
                    start = middle +1;
                }

            }else{
                if (nums[end] >= target && target > nums[middle]){
                    start = middle +1;
                }else {
                    end = middle -1;
                }

            }

        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(searchRotateArray.search(nums, target));
    }

}
