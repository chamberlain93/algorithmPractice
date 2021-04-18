package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/18.
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        quicksort(intervals, 0, intervals.length - 1);
        int head = intervals[0][0];
        int tail = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (tail < intervals[i][0]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(head);
                temp.add(tail);
                list.add(temp);
                head = intervals[i][0];
                tail = intervals[i][1];
                continue;
            } else {
                if (tail > intervals[i][1]) {
                    continue;
                } else {
                    tail = intervals[i][1];
                }
            }

        }
        List<Integer> last = new ArrayList<>();
        last.add(head);
        last.add(tail);
        list.add(last);
        int[][] result = new int[list.size()][];
        int i = 0;
        for (List<Integer> item : list) {
            int[] temp = new int[item.size()];
            int j = 0;
            for (Integer integer : item) {
                temp[j] = integer;
                j++;
            }
            result[i] = temp;
            i++;
        }
        return result;
    }

    int partition(int array[][], int start, int end) {
        int i = start;
        int j = end;
        int[] temp = array[start];
        while (i != j) {
            while (array[j][0] >= temp[0] && i < j) {
                j--;
            }
            while (array[i][0] <= temp[0] && i < j) {
                i++;
            }
            if (i < j) {
                int[] t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[start] = array[i];
        array[i] = temp;
        return i;
    }

    void quicksort(int array[][], int start, int end) {
        int q = -1;
        if (start < end) {
            q = partition(array, start, end);
            quicksort(array, start, q - 1);
            quicksort(array, q + 1, end);
        }
    }

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        int[][] intervals = {{4, 5},{1, 4}};
        for (int[] array : mergeInterval.merge(intervals)) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
