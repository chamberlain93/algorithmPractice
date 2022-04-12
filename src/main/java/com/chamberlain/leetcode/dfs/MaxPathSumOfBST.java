package com.chamberlain.leetcode.dfs;

import com.chamberlain.acm.chapter_2_1.DFS;
import com.chamberlain.leetcode.basicClass.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 */
public class MaxPathSumOfBST {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root);
        return max;

    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        max = Math.max(max, leftMax +rightMax + root.val);
        return Math.max(0,Math.max(root.val + leftMax, root.val + rightMax));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);

        TreeNode node4 = new TreeNode(15);

        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right= node5;

        MaxPathSumOfBST maxPathSumOfBST = new MaxPathSumOfBST();
        System.out.println(maxPathSumOfBST.maxPathSum(node1));



    }
}
