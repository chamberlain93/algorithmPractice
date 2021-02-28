package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/2/28.判断一颗二叉树是否合格
 */
public class JudgeBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return false;
        }
        traceBST(result, root);
        if (result.size()==1){
            return true;
        }
        for (int i = 0; i < result.size() -1; i++) {
            if (result.get(i) > result.get(i+1)){
                return false;
            }
        }
        
        return true;
    }


    /**
     * 中序遍历二叉树
     */

    public void traceBST(List<Integer> result, TreeNode root){

        if (root == null){
            return;
        }
        traceBST(result, root.left);
        result.add(root.val);
        traceBST(result,root.right);
    }

    public static void main(String[] args) {
        JudgeBST judgeBST = new JudgeBST();
        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(18);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(17);
        TreeNode node6 = new TreeNode(19);
        TreeNode node7 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node5;
        node3.right = node6;
        node2.right = node4;
        node6.right = node7;
        System.out.println(judgeBST.isValidBST(node1));
    }


}
