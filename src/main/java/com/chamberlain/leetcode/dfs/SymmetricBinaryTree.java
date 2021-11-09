package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        return compareLeftAndRight(root.left, root.right);

    }

    public boolean compareLeftAndRight(TreeNode left, TreeNode right){

        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }

        return compareLeftAndRight(left.right, right.left) && compareLeftAndRight(left.left, right.right);
    }
}
