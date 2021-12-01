package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class PathQuantityOfBT {

    List<List<Integer>> allPath = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        trace(root, new ArrayList<>());
        for (List<Integer> item : allPath) {
            StringJoiner sj = new StringJoiner("->");
            for (Integer integer : item) {
                sj.add(integer.toString());
            }
            result.add(sj.toString());
        }
        return result;
    }

    public void trace(TreeNode root, List<Integer> path){
        if (root == null){
            path.add(null);
            return;
        }
        if (root.left == null && root.right == null){
            path.add(root.val);
            allPath.add(new ArrayList<>(path));
            return;
        }

        path.add(root.val);
        trace(root.left, path);
        path.remove(path.size()-1);
        trace(root.right, path);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        PathQuantityOfBT pathQuantityOfBT = new PathQuantityOfBT();
        for (String s : pathQuantityOfBT.binaryTreePaths(node1)) {
            System.out.println(s);
        }
    }
}
