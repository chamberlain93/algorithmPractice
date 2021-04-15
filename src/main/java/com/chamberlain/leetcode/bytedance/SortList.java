package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> nums = new ArrayList<>();
        nums.add(head.val);
        while (head.next != null) {
            nums.add(head.next.val);
            head = head.next;
        }
        int[] array = new int[nums.size()];
        int i = 0;
        for (Integer num : nums) {
            array[i] = num;
            i++;
        }
        quickSort(array, 0, array.length-1);
        ListNode result = new ListNode(array[0]);
        ListNode current = result;
        for (int j = 1; j < array.length; j++) {
            current.next = new ListNode(array[j]);
            current = current.next;
        }
        return result;

    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int temp = arr[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && arr[j] > temp)
                    j--;
                arr[i] = arr[j];
                while (i < j && arr[i] <= temp)
                    i++;
                arr[j] = arr[i];
            }
            arr[i] = temp;
            quickSort(arr, begin, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next=node4;
        System.out.println(sortList(node1));
    }
}
