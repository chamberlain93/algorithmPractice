package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.ListNode;

/**
 * Created by chamberlain on 2021/4/17.
 * 两两交换链表中的节点
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        //先将链表拆分，再合并
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTemp= oddHead;
        ListNode evenTemp = evenHead;
        ListNode temp = evenHead.next;
        int k = 3;
        while (temp != null){
            if (k%2 == 1){
                oddTemp.next = temp;
                oddTemp = oddTemp.next;
            }else {
                evenTemp.next = temp;
                evenTemp = evenTemp.next;
            }
            k++;
            temp = temp.next;
        }
        if (k%2 == 1){
            oddTemp.next = null;
        }else {
            evenTemp.next = null;
        }

        //合并链表
        ListNode oddTemp1= oddHead;
        ListNode evenTemp1 = evenHead;
        while(evenTemp1 != null){
            ListNode evenTemp2 = evenTemp1.next;
            ListNode oddTemp2 = oddTemp1.next;
            evenTemp1.next = oddTemp1;
            if (evenTemp2 != null){
                oddTemp1.next = evenTemp2;
            }
            oddTemp1 = oddTemp2;
            evenTemp1 = evenTemp2;

        }

        return evenHead;

    }

    public ListNode swapPairs1(ListNode head) {

        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode pre = head.next;
        ListNode behind = new ListNode(-1);
        ListNode cur = head;
        ListNode newNode = pre;
        while(cur != null && cur.next != null){
            cur.next = cur.next.next;
            pre.next = cur;
            behind.next = pre;
            behind = cur;
            cur = cur.next;
            if (cur != null){
                pre = cur.next;
            }

        }

        return newNode;


    }


    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(swapPairs.swapPairs1(node1));
    }
}
