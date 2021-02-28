package com.chamberlain.leetcode.bytedance;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/2/28. 锯齿状的遍历二叉树
 */
public class ZigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int level = 1;
        List<TreeNode> element = new ArrayList<>();
        element.add(root);
        while(element.size() != 0){
            trace(result,element, level);
            List<TreeNode> tempElement = new ArrayList<>();
            for (TreeNode treeNode : element) {
                if (treeNode.left != null){
                    tempElement.add(treeNode.left);
                }
                if (treeNode.right != null){
                    tempElement.add(treeNode.right);
                }
                element = tempElement;
            }
            level++;
        }

        return result;

    }

    public void trace(List<List<Integer>> result, List<TreeNode> childNodeList, int level){

        List<Integer> element = new ArrayList<>();

        if (level % 2 == 1){
            for (TreeNode treeNode : childNodeList) {
                element.add(treeNode.val);
            }
        }else {
            for (int i = childNodeList.size() - 1; i >= 0; i--) {
                element.add(childNodeList.get(i).val);
            }
        }

        result.add(element);
    }

    public static void main(String[] args) {
        ZigzagLevelOrder zigzag = new ZigzagLevelOrder();
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
        for (List<Integer> integerList : zigzag.zigzagLevelOrder(node1)) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
