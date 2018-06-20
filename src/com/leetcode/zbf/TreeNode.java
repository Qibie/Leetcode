package com.leetcode.zbf;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

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
