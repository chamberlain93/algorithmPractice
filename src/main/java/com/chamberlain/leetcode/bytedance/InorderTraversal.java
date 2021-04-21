package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        trace(root,result);
        return result;
    }

    public void trace(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        trace(root.left,result);
        result.add(root.val);
        trace(root.right,result);

    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(19);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;
        for (Integer integer : inorderTraversal.inorderTraversal(node1)) {
            System.out.println(integer);
        }
    }
}
