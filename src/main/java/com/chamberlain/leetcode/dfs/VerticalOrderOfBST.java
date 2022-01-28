package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 *
 * https://leetcode-cn.com/problems/binary-tree-vertical-order-traversal/
 */
public class VerticalOrderOfBST {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> levelTrace = new ArrayDeque<>();
        Queue<Integer> levelOrder = new ArrayDeque<>();

        Map<Integer, List<Integer>> mapResult = new HashMap<>();
        levelTrace.add(root);
        levelOrder.add(0);

        while (!levelTrace.isEmpty() && !levelOrder.isEmpty()){
            TreeNode current = levelTrace.poll();
            Integer currentOrder = levelOrder.poll();
            mapResult.computeIfAbsent(currentOrder, k->new ArrayList<>()).add(current.val);
            if (current.left != null){
                levelTrace.add(current.left);
                levelOrder.add(currentOrder - 1);
            }

            if(current.right != null){
                levelTrace.add(current.right);
                levelOrder.add(currentOrder + 1);
            }

        }

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> keySet = new TreeSet<>(mapResult.keySet());
        for (Integer integer : keySet) {
            result.add(mapResult.get(integer));
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node8;
        node3.right = node9;
        node5.left = node6;
        node5.right = node7;
        
        VerticalOrderOfBST bst = new VerticalOrderOfBST();
        bst.verticalOrder(node1).toString();
    }
}
