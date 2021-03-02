package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.ListNode;

/**
 * Created by chamberlain on 2021/3/1.
 */
public class DeleteDuplicateListNodeII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode end = result;
        ListNode pre = null;
        ListNode next = head.next;
        while ( head != null) {
            if ((next != null && head.val == next.val) || (pre != null && pre.val == head.val)){
                pre = new ListNode(head.val);
                head = head.next;
                if (head!= null && head.next != null){
                    next = new ListNode(head.next.val);
                }else{
                    next = null;
                }

            }else {
                end.val = head.val;
                pre = new ListNode(head.val);
                head = head.next;
                if (head != null){
                    end.next = new ListNode(Integer.MIN_VALUE);
                    end = end.next;
                }
                if (head!= null && head.next != null){
                    next = new ListNode(head.next.val);
                }else {
                    next = null;
                }
            }

        }

        if (result.val == Integer.MIN_VALUE){
            return null;
        }

        //去除默认初始化的节点
        ListNode temp = result;
        while(temp.next != null){
            if (temp.val > temp.next.val){
                temp.next = null;
            }else {
                temp = temp.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        DeleteDuplicateListNodeII deleteDuplicateListNode = new DeleteDuplicateListNodeII();
        ListNode result = deleteDuplicateListNode.deleteDuplicates(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
