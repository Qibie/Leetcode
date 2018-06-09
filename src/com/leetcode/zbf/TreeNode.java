package com.leetcode.zbf;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (left != null) {
            stringBuilder.append(left.toString());
        }
        stringBuilder.append(val);
        if (right != null) {
            stringBuilder.append(right.toString());
        }
        return stringBuilder.toString();
    }
}
