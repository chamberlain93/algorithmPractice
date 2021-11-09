package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

/**
 * Created by chamberlain on 2021/11/9.
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinDepthOfTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null){
            return minDepth(root.right) + 1;
        }else if(root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
