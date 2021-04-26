package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/24.
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 */
public class TreeNodeToList {

    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        trace(nodeList, root);
        TreeNode temp = root;
        for (int i = 1; i < nodeList.size(); i++) {
            temp.right = nodeList.get(i);
            temp.left =  null;
            temp = temp.right;
        }

    }

    public void trace(List<TreeNode> nodeList, TreeNode root){

        if (root == null){
            return;
        }
        nodeList.add(root);
        trace(nodeList, root.left);
        trace(nodeList, root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(19);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;
        node1.left = node2;
        TreeNodeToList treeNodeToList = new TreeNodeToList();
        treeNodeToList.flatten(node1);
        System.out.println(node1.val);
    }
}
