package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 */
public class WidthOfBT {

    public int widthOfBinaryTree(TreeNode root) {
        //层次遍历二叉树
        if (root == null) {
            return 0;
        }
        int max = 1;
        List<TreeNode> temp = new ArrayList<>();
        List<Integer> numTemp = new ArrayList<>();
        List<Integer> numTemp1 = new ArrayList<>();
        temp.add(root);
        numTemp.add(0);
        while (temp.size() > 0) {
            List<TreeNode> temp1 = new ArrayList<>(temp);
            temp.clear();
            for (int i = 0; i < temp1.size(); i++) {
                if (temp1.get(i).left != null ) {
                    temp.add(temp1.get(i).left);
                    numTemp1.add(numTemp.get(i) * 2 + 1);
                }

                if (temp1.get(i).right != null){
                    temp.add(temp1.get(i).right);
                    numTemp1.add(numTemp.get(i) * 2 + 2);
                }
            }

            if (numTemp1.size() != 0 && numTemp1.get(numTemp1.size() -1 ) - numTemp1.get(0) + 1 > max){
                max = numTemp1.get(numTemp1.size() -1 ) - numTemp1.get(0) + 1;
            }

            numTemp = new ArrayList<>(numTemp1);
            numTemp1.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        node1.right =  node5;
        node5.right = node6;
        node6.right = node7;
        WidthOfBT widthOfBT = new WidthOfBT();
        System.out.println(widthOfBT.widthOfBinaryTree(node1));
    }
}
