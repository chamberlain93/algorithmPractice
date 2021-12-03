package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBT {
    public int diameterOfBinaryTree(TreeNode root) {

        return root == null ? 0 : Math.max(depth(root.right)+ depth(root.left) ,Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
