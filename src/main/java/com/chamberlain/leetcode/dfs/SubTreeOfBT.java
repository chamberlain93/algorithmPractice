package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class SubTreeOfBT {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean judge(TreeNode p, TreeNode q) {
        if (q == null) {
            return true;
        }
        if (p == null || p.val != q.val) {
            return false;
        }
        return judge(p.left, q.left) && judge(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        TreeNode node7 = new TreeNode(10);
        TreeNode node8 = new TreeNode(12);
        TreeNode node9 = new TreeNode(6);
        TreeNode node10 = new TreeNode(8);
        node7.left = node8;
        node7.right = node9;
        node8.left = node10;
        SubTreeOfBT subTreeOfBT = new SubTreeOfBT();
        System.out.println(subTreeOfBT.isSubStructure(node1, node7));
    }
}
