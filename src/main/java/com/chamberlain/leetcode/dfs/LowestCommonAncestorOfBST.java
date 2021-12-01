package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */
public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<Integer> pNodeList = new ArrayList<>();
        trace(root, p, pNodeList);
        List<Integer> qNodeList = new ArrayList<>();
        trace(root, q, qNodeList);
        for (int i = 1; i < Math.min(pNodeList.size(), qNodeList.size()); i++) {
            if (!pNodeList.get(i).equals(qNodeList.get(i))){
                return new TreeNode(pNodeList.get(i-1));
            }
        }

        return pNodeList.size() > qNodeList.size() ? new TreeNode(qNodeList.get(qNodeList.size() - 1)): new TreeNode(pNodeList.get(pNodeList.size() - 1));

    }


    public void trace(TreeNode root, TreeNode target, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val > target.val) {
            trace(root.left, target, path);
        } else if (root.val < target.val){
            trace(root.right, target, path);
        }
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
        List<Integer> path = new ArrayList<>();
        LowestCommonAncestorOfBST lowestCommonAncestorOfBST = new LowestCommonAncestorOfBST();
        System.out.println(lowestCommonAncestorOfBST.lowestCommonAncestor(node1, node2, node5).val);

    }
}
