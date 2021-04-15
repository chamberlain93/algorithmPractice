package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.ListNode;

/**
 * Created by chamberlain on 2021/4/15.
 */
public class ReorderList {

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null){
            return;
        }
        //求链表长度并复制新链表
        int length = 1;
        ListNode cur = head;

        ListNode copyListNode = new ListNode(head.val);
        ListNode cur1 = copyListNode;
        while(cur.next != null){
            cur1.next = new ListNode(cur.next.val);
            cur1 = cur1.next;
            cur = cur.next;
            length++;
        }
        //头插法生成翻转链表
        ListNode newHead = reverseList(copyListNode);
        int half = length/2;
        ListNode temp = head;
        ListNode temp1 = newHead;
        while (half > 0){
            ListNode temp2 = temp.next;
            ListNode temp3 = temp1.next;
            temp.next = temp1;
            if (half > 1){
                temp1.next = temp2;
                temp = temp2;
                temp1 = temp3;
            }else {
                if (length%2 ==1){
                    temp1.next = temp2;
                    temp2.next = null;
                }else {
                    temp1.next = null;
                }
            }

            half--;
        }

    }


    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reorderList(node1);
        System.out.println();
    }
}
