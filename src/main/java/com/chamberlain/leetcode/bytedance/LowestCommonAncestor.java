package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/18.
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pNodeList = trace(root, p);
        List<TreeNode> qNodeList = trace(root, q);
        for (int i = 1; i < Math.min(pNodeList.size(), qNodeList.size()); i++) {
            if (pNodeList.get(i).val != qNodeList.get(i).val) {
                return pNodeList.get(i-1);
            }
        }


        return pNodeList.size() > qNodeList.size() ? qNodeList.get(qNodeList.size() - 1) : pNodeList.get(pNodeList.size() - 1);

    }


    //找到从根节点到目标节点的路径
    public List<TreeNode> trace(TreeNode root, TreeNode target) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root);
        if (root.val == target.val) {
            return result;
        }
        result.addAll(trace(root.left, target));
        result.addAll(trace(root.right, target));
        if (result.get(result.size()-1).val == target.val){
            return result;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(19);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(node1,node4,node7).val);
    }
}
