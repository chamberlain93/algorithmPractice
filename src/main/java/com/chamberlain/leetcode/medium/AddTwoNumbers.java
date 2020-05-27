package com.chamberlain.leetcode.medium;


import com.chamberlain.leetcode.basicClass.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode newNode = new ListNode();
        recursive(newNode,node1,node2,0);
        return newNode;
    }


    private void recursive(ListNode newNode, ListNode node1, ListNode node2,int tenDigits) {

        int digits;

        if (node1 == null && node2 == null) {
            if (tenDigits==1){
                newNode.val = tenDigits;
                newNode.next = null;
            }
            return;
        }
        if (node1 == null) {
            int temp = node2.val + tenDigits;
            digits = temp % 10;
            tenDigits = temp/10;
            newNode.val = digits;
            if (node2.next==null){
                if (tenDigits==1){
                    newNode.next = new ListNode();
                    newNode.next.val = tenDigits;
                    newNode.next.next = null;
                }
            }else {
                newNode.next = new ListNode();
                recursive(newNode.next, null, node2.next,tenDigits);
            }

        }
        if (node2 == null) {
            int temp = node1.val + tenDigits;
            digits = temp % 10;
            tenDigits = temp/10;
            newNode.val = digits;
            if (node1.next ==null){
                if (tenDigits==1){
                    newNode.next = new ListNode();
                    newNode.next.val = tenDigits;
                    newNode.next.next = null;
                }
            }else {
                newNode.next = new ListNode();
                recursive(newNode.next, node1.next, null,tenDigits);
            }

        }


        if (node1 != null && node2 != null) {
            int temp = node1.val + node2.val + tenDigits;
            digits = temp % 10;
            tenDigits = temp / 10;
            newNode.val = digits;
            if (node1.next==null&&node2.next==null){
                if (tenDigits==1){
                    newNode.next = new ListNode();
                    newNode.next.val = tenDigits;
                    newNode.next.next = null;
                }
            }else {
                newNode.next = new ListNode();
                recursive(newNode.next, node1.next, node2.next,tenDigits);
            }

        }
    }

    private static void printNode(ListNode node){
        if (node!=null){
            System.out.print(node.val+"->");
        }else {
            return;
        }

        printNode(node.next);
    }

    public static void main(String[] args){
        ListNode node3= new ListNode(3,null);
        ListNode node2= new ListNode(4,node3);
        ListNode node1= new ListNode(2,node2);

        ListNode node6= new ListNode(4,null);
        ListNode node5= new ListNode(6,node6);
        ListNode node4= new ListNode(5,node5);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode newNode = addTwoNumbers.addTwoNumbers(node1,node4);
        printNode(newNode);



    }
}
