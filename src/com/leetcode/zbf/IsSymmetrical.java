package com.leetcode.zbf;

import java.util.ArrayList;

public class IsSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left != null && right != null) {
            return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
        }
        return false;
    }


//    public void posErgodic(TreeNode root, ArrayList<Integer> posList) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null)
//            posErgodic(root.left, posList);
//        posList.add(root.val);
//        if (root.right != null)
//            posErgodic(root.right, posList);
//    }
//
//    public void negErgodic(TreeNode root, ArrayList<Integer> negList) {
//        if (root == null)
//            return;
//        if (root.right != null)
//            negErgodic(root.right, negList);
//        negList.add(root.val);
//        if (root.left != null)
//            negErgodic(root.left, negList);
//    }


}
