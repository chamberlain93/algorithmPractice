package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 解题思路,层次遍历二叉树
 */
public class RightSideViewOfBT {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        if (root.left == null && root.right==null){
            result.add(root.val);
            return result;
        }
        List<TreeNode> element = new ArrayList<>();
        element.add(root);
        while(element.size() != 0){
            result.add(element.get(element.size()-1).val);
            List<TreeNode> tempElement = new ArrayList<>();
            for (TreeNode treeNode : element) {
                if (treeNode.left != null){
                    tempElement.add(treeNode.left);
                }
                if (treeNode.right != null){
                    tempElement.add(treeNode.right);
                }
                element = tempElement;
            }
        }

        return result;

    }

    public static void main(String[] args) {
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
        for (Integer integer : rightSideView(node1)) {
            System.out.println(integer);
        }
    }
}
