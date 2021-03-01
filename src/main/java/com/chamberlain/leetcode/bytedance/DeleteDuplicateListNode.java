package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.ListNode;

import java.util.List;

/**
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicateListNode {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode temp = head;
        while ( temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        DeleteDuplicateListNode deleteDuplicateListNode = new DeleteDuplicateListNode();
        ListNode result = deleteDuplicateListNode.deleteDuplicates(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
