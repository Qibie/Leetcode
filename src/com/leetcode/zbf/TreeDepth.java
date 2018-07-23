package com.leetcode.zbf;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.RecursiveTask;

public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        return IsBalanced(root, new int[1]);
    }


    public boolean IsBalanced(TreeNode root, int[] length) {
        if (root == null) {
            length[0] = 0;
            return true;
        }
        int[] length_left = new int[1], length_righ = new int[1];
        if (IsBalanced(root.left, length_left) && IsBalanced(root.right, length_righ)) {
            if ((length_left[0] - length_righ[0] <= 1) && length_left[0] - length_righ[0] >= -1) {
                length[0] = 1 + Math.max(length_left[0], length_righ[0]);
                return true;
            }
            return false;
        }
        return false;
    }


}
