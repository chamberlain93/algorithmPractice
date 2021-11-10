package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

/**
 * 给你二叉树的根节点root和一个表示目标和的整数targetSum ，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum
 *
 * 链接：https://leetcode-cn.com/problems/path-sum
 *
 */
public class BinaryTreePathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null && root.val == targetSum){
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
