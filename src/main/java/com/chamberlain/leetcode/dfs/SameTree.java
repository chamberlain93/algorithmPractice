package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree {

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();
        traceTreeByMidOrder(pList, p);
        traceTreeByMidOrder(qList, q);
        traceTreeByPreOrder(pList, p);
        traceTreeByPreOrder(qList, q);
        if (pList.size() != qList.size()) {
            return false;
        }

        for (int i = 0; i < pList.size(); i++) {
            if (!qList.get(i).equals(pList.get(i))) {
                return false;
            }
        }
        return true;
    }


    public void traceTreeByMidOrder(List<Integer> result, TreeNode root) {

        if (root == null) {
            result.add(100001);
            return;
        }
        traceTreeByMidOrder(result, root.left);
        result.add(root.val);
        traceTreeByMidOrder(result, root.right);
    }

    public void traceTreeByPreOrder(List<Integer> result, TreeNode root) {

        if (root == null) {
            result.add(100001);
            return;
        }
        result.add(root.val);
        traceTreeByPreOrder(result, root.left);
        traceTreeByPreOrder(result, root.right);
    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        //node1.right = node3;
        //node4.left = node5;
        node4.right = node6;
        System.out.println(sameTree.isSameTree(node1, node4));
    }
}
