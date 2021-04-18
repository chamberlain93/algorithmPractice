package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chamberlain on 2021/4/17.
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int length = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            } else {
                numMap.put(nums[i], 1);
            }
        }

        int[] frequentNums = new int[nums.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            frequentNums[i] = entry.getValue();
            i++;
        }

        int j = 0;
        build_max_heap(frequentNums, length);
        while (k > 0) {
            //获取大顶堆
            result[j] = Heap_extract_max(frequentNums, length--);
            j++;
            k--;
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i1 : result) {
            resultList.add(i1);
        }

        int m = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (resultList.contains(entry.getValue())) {
                result[m] = entry.getKey();
                m++;
                if (m > result.length - 1) {
                    break;
                }
            }
        }

        return result;

    }

    void build_max_heap(int heapArray[], int length) {//通过普通数组构建最大堆
        for (int i = length / 2; i >= 1; i--) {
            Max_Heapify(heapArray, i, length);
        }
    }

    int Heap_extract_max(int heapArray[], int length) {//在最大堆里提取key值最大的元素,删除后保持最大堆状态
        if (length < 1) {
            return 0;
        }
        int max = heapArray[0];
        heapArray[0] = heapArray[length - 1];
        length = length - 1;
        Max_Heapify(heapArray, 1, length);//为了让新堆保持最大堆
        return max;

    }

    void Max_Heapify(int heapArray[], int i, int length) {//调整数组的顺序，使其满足最大堆性质
        int left = 2 * i;//左子树跟节点下标
        int right = 2 * i + 1;//右子树跟节点下标
        int largest;
        if (left <= length && heapArray[left - 1] > heapArray[i - 1]) {//左子树根节点大于跟节点
            largest = left;
        } else {
            largest = i;
        }
        if (right <= length && heapArray[right - 1] > heapArray[largest - 1]) {//左子树根节点大于跟节点
            largest = right;
        }
        if (largest != i) {
            int temp = heapArray[largest - 1];
            heapArray[largest - 1] = heapArray[i - 1];
            heapArray[i - 1] = temp;
            Max_Heapify(heapArray, largest, length);
        }
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = {1};
        int k = 1;
        for (int i : topKFrequent.topKFrequent(nums, k)) {
            System.out.println(i);
        }
    }


}
