package com.leetcode.zbf;

public class HasSubtree {
    public boolean hasSubstree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val == treeNode2.val && equalTree(treeNode1, treeNode2)) {
            return true;
        } else {
            if (hasSubstree(treeNode1.left, treeNode2)) {
                return true;
            } else {
                return hasSubstree(treeNode1.right, treeNode2);
            }
        }
    }

    public boolean equalTree1(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1.val != treeNode2.val) {
            return false;
        }
        boolean flag = true;
        if ((treeNode1.left != null && treeNode2.left != null)) {
            flag = flag && equalTree1(treeNode1.left, treeNode2.left);
        } else if (treeNode2.left == null) {
            flag = flag && true;
        } else {
            return false;
        }
        if ((treeNode1.right != null && treeNode2.right != null)) {
            flag = flag && equalTree1(treeNode1.right, treeNode2.right);
        } else if (treeNode2.right == null) {
            flag = flag && true;
        } else {
            return false;
        }
        return flag;
    }


    public boolean equalTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        } else {
            return equalTree(treeNode1.left, treeNode2.left) && equalTree(treeNode1.right, treeNode2.right);
        }

    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        treeNode1.left = new TreeNode(8);
        treeNode1.right = new TreeNode(7);
        treeNode1.left.left = new TreeNode(9);
        treeNode1.left.right = new TreeNode(2);
        treeNode1.left.right.left = new TreeNode(4);
        treeNode1.left.right.right = new TreeNode(7);


        TreeNode treeNode2 = new TreeNode(8);
        treeNode2.left = new TreeNode(9);
        treeNode2.right = new TreeNode(2);
        System.out.println(new HasSubtree().hasSubstree(treeNode1, treeNode2));
    }
}
