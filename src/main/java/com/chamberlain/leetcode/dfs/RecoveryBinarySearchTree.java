package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 */
public class RecoveryBinarySearchTree {

    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode err1;
    TreeNode err2;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        traceBST(root);
        int temp = err2.val;
        err2.val = err1.val;
        err1.val = temp;
    }

    public void traceBST(TreeNode root) {

        if (root == null) {
            return;
        }
        traceBST(root.left);

        if (preNode.val > root.val && err1 == null) {
            err1 = preNode;
        }

        if (preNode.val > root.val) {
            err2 = root;
        }
        preNode = root;
        traceBST(root.right);
    }

    public static void main(String[] args) {
        RecoveryBinarySearchTree recoveryBinarySearchTree = new RecoveryBinarySearchTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        recoveryBinarySearchTree.recoverTree(node1);
        System.out.println(node1.val);
    }

}
