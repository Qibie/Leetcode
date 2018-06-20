package com.leetcode.zbf;

import sun.reflect.generics.tree.Tree;

public class ConvertTreeNode {
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if (pRootOfTree == null) {
//            return null;
//        }
//        recurrsionConvert(pRootOfTree);
//        TreeNode tHead = pRootOfTree;
//        while (tHead.left != null) {
//            tHead = tHead.left;
//        }
//
//        return tHead;
//    }

//    public void recurrsionConvert(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        TreeNode left_temp = node.left, right_temp = node.right;
//        node.left = getMaxLeft(node);
//        if (node.left != null) {
//            node.left.right = node;
//        }
//        node.right = getMinRight(node);
//        if (node.right != null) {
//            node.right.left = node;
//        }
//        recurrsionConvert(left_temp);
//        recurrsionConvert(right_temp);
//    }
//
//    public TreeNode getMaxLeft(TreeNode node) {
//        if (node.left == null) {
//            return null;
//        }
//        TreeNode leftMaxNode = node.left;
//        while (leftMaxNode.right != null) {
//            leftMaxNode = leftMaxNode.right;
//        }
//        return leftMaxNode;
//    }
//
//    public TreeNode getMinRight(TreeNode node) {
//        if (node.right == null) {
//            return null;
//        }
//        TreeNode rightMinNode = node.right;
//        while (rightMinNode.left != null) {
//            rightMinNode = rightMinNode.left;
//        }
//        return rightMinNode;
//    }

    TreeNode lastOfInitList;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode phead = lastOfInitList;
        concertTree(pRootOfTree);
        while (phead != null && phead.left != null)
            phead = phead.left;
        return phead;
    }


    public void concertTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            concertTree(node.left);
        }
        node.left = lastOfInitList;
        if (lastOfInitList != null) {
            lastOfInitList.right = node;
        }
        lastOfInitList = node;
        if (node.right != null) {
            concertTree(node.right);
        }
    }

    public TreeNode Convert_1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert_1(pRootOfTree.left), p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (p != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        TreeNode right = Convert_1(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left != null ? left : pRootOfTree;

    }


}
