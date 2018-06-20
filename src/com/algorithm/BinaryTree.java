package com.algorithm;

import com.leetcode.zbf.TreeNode;

import java.util.Stack;

/**
 * 二叉树非递归遍历算法
 */
public class BinaryTree {

    /**
     * 非递归前序遍历
     *
     * @param node
     */
    void PreTravelRecursion(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node == null) {
            return;
        }
        TreeNode temp = node;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                System.out.println(temp.val);
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                temp = temp.right;
            }
        }
    }

    /**
     * 非递归中序遍历
     *
     * @param node
     */
    void InOrderTraverseTree(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.val);
                temp = temp.right;
            }

        }
    }


    /**
     * 非递归后序遍历
     *
     * @param node
     */
    void LastTraverseTree(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode preNode = node, temp = node;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(temp);
        while (!stack.isEmpty()) {
            temp = stack.peek();
            if ((temp.left == null && temp.right == null) || (temp.right == null && preNode == temp.left) || preNode == temp.right) {
                System.out.println(temp.val);
                preNode = temp;
                stack.pop();
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        treeNode1.left = new TreeNode(6);
        treeNode1.right = new TreeNode(14);
        treeNode1.left.left = new TreeNode(4);
        treeNode1.left.right = new TreeNode(8);
        treeNode1.right.left = new TreeNode(12);
        treeNode1.right.right = new TreeNode(16);
        new BinaryTree().LastTraverseTree(treeNode1);
    }

}
