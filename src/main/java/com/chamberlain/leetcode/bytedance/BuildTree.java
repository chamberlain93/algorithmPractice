package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.Arrays;

/**
 * Created by chamberlain on 2021/4/17.
 * 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0){
            return null;
        }
        if (inorder.length == 0){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);

        int tmp = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                tmp = i;
            }
        }

        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + tmp), Arrays.copyOfRange(inorder, 0, tmp));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, 1 + tmp, preorder.length), Arrays.copyOfRange(inorder, tmp + 1, inorder.length));
        return treeNode;
    }


    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preOrder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree.buildTree(preOrder,inorder));
    }
}
