package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个二叉树。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 */
public class ConnectNodeOfSameLevelII {

    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node current = null;
            Node preNode = null;
            for (int i = 0; i < size; i++) {
                preNode = queue.poll();
                if (i != 0) {
                    current.next = preNode;
                }
                current = preNode;
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            preNode.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        ConnectNodeOfSameLevelII connectNodeOfSameLevel = new ConnectNodeOfSameLevelII();
        connectNodeOfSameLevel.connect(node1);
    }

}
