package com.leetcode.zbf;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

public class PrintFromTopToBottom {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        TreeNode temp = null;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            temp = treeNodes.get(0);
            result.add(temp.val);
            if (temp.left != null) {
                treeNodes.add(temp.left);
            }
            if (temp.right != null) {
                treeNodes.add(temp.right);
            }
            treeNodes.remove(0);
        }
        return result;
    }


}
