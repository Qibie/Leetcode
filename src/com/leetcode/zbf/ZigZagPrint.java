package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeNode node;
        s1.push(pRoot);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while (!s1.isEmpty()) {
                node = s1.pop();
                temp.add(node.val);
                if (node.left != null)
                    s2.push(node.left);
                if (node.right != null)
                    s2.push(node.right);
            }
            result.add(temp);
            temp = new ArrayList<Integer>();
            while (!s2.isEmpty()) {
                node = s2.pop();
                temp.add(node.val);
                if (node.right != null)
                    s1.push(node.right);
                if (node.left != null)
                    s1.push(node.left);
            }
            result.add(temp);
        }
        return result;
    }
}
