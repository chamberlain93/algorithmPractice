package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 */
public class LargestBSTSubtree {

    public int largestBSTSubtree(TreeNode root) {

        if(root == null){
            return 0;
        }
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return count(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    boolean isBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }


    public int count(TreeNode root){
        if (root == null){
            return 0;
        }

        return count(root.left) + count(root.right) + 1;
    }
}
