package com.chamberlain.leetcode.dfs;

import com.chamberlain.leetcode.basicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *翻转一棵二叉树,左子树右子树上的节点对换
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class ReverseBinaryTree {


    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        List<Integer> orderMiddleReverse = traverseMiddleReverse(root);
        List<Integer> orderPreviousReverse = traversePreviousReverse(root);
        int[] orderMiddleReverseArray = new int[orderMiddleReverse.size()];
        int[] orderPreviousReverseArray = new int[orderPreviousReverse.size()];
        for (int i = 0; i < orderMiddleReverse.size(); i++) {
            orderMiddleReverseArray[i] = orderMiddleReverse.get(i);
            orderPreviousReverseArray[i] = orderPreviousReverse.get(i);
        }
        return buildTree(orderMiddleReverseArray, orderPreviousReverseArray, 0, orderMiddleReverseArray.length -1, 0, orderPreviousReverseArray.length -1 );
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode result = new TreeNode(root.val);
        result.left = invertTree2(root.right);
        result.right = invertTree2(root.left);
        return result;
    }

    private TreeNode buildTree(int[] orderMiddleReverseArray, int[] orderPreviousReverseArray, int midStart,
                               int midEnd, int preStart, int preEnd){

        if (midStart > midEnd || preStart > preEnd){
            return null;
        }

        TreeNode root = new TreeNode(orderPreviousReverseArray[preStart]);
        for (int i= midStart; i<= midEnd; i++ ){
            if (orderMiddleReverseArray[i] == orderPreviousReverseArray[preStart]){
                root.left = buildTree(orderMiddleReverseArray, orderPreviousReverseArray, midStart, i-1, preStart + 1, preStart + i - midStart);
                root.right = buildTree(orderMiddleReverseArray, orderPreviousReverseArray, i + 1, midEnd, preStart + i + 1 - midStart, preEnd);
            }
        }

        return root;


    }

    public List<Integer> traverseMiddleReverse(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> orderMiddleReverse = new ArrayList<>(traverseMiddleReverse(root.right));
        orderMiddleReverse.add(root.val);
        orderMiddleReverse.addAll(traverseMiddleReverse(root.left));
        return orderMiddleReverse;

    }

    public List<Integer> traversePreviousReverse(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> orderPreviousReverse = new ArrayList<>();
        orderPreviousReverse.add(root.val);
        orderPreviousReverse.addAll(traversePreviousReverse(root.right));
        orderPreviousReverse.addAll(traversePreviousReverse(root.left));
        return orderPreviousReverse;
    }

    public static void main(String[] args) {
        ReverseBinaryTree reverseBinaryTree = new ReverseBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(reverseBinaryTree.invertTree(node1).left.val);
    }
}
