package com.leetcode.zbf;

import java.util.Stack;

public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(pRoot);
        TreeNode temp = pRoot.left;
        int i = 0;
        while (!treeNodes.isEmpty() || temp!=null) {
            if (temp != null) {
                treeNodes.push(temp);
                temp = temp.left;
            } else {
                temp = treeNodes.pop();
                ++i;
                if (i == k)
                    return temp;
                temp = temp.right;
            }
        }
        return null;
    }
}
