package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/23.
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class PathSumOfBT {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        trace(result, new ArrayList<>(), root, target);
        return result;
    }

    public void trace(List<List<Integer>> result, List<Integer> numList, TreeNode root, int target){

        if (root == null){
            return;
        }
        target = target - root.val;
        if (target  == 0 && root.left ==  null && root.right == null){
            numList.add(root.val);
            result.add(new ArrayList<>(numList));
            numList.remove(numList.size()-1);
            return;
        }
        numList.add(root.val);
        trace(result, numList, root.left, target);
        trace(result,numList,root.right, target);
        numList.remove(numList.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(18);
        TreeNode node7 = new TreeNode(19);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;
        node1.left = node2;
        PathSumOfBT pathSumOfBT = new PathSumOfBT();
        System.out.println(pathSumOfBT.pathSum(node1, 31));

    }
}
