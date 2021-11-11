package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 */
public class SumOfBinaryPathNum {

    List<List<Integer>> totalResult = new ArrayList<>();

    public int sumNumbers(TreeNode root) {

        trace(new ArrayList<>(), root);
        int result = 0;
        for (List<Integer> list : totalResult) {
            String str = "";
            for (Integer integer : list) {
                str = str + integer;
            }
            result += Integer.parseInt(str);

        }
        return result;
    }

    public void trace(List<Integer> result, TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            totalResult.add(new ArrayList<>(result));
            result.remove(result.size() - 1);
            return;
        }
        result.add(root.val);
        trace(result, root.left);
        trace(result, root.right);
        result.remove(result.size() - 1);

    }

    public static void main(String[] args) {
        SumOfBinaryPathNum sumOfBinaryPathNum = new SumOfBinaryPathNum();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        sumOfBinaryPathNum.sumNumbers(node1);
    }
}
