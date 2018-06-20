package com.leetcode.zbf;

import java.util.ArrayList;

public class FindAllPath {

    private ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
    private ArrayList<Integer> currentPath = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return allPath;
        }
        findAllPath(root, target);
        return allPath;
    }

    public void findAllPath(TreeNode root, int target) {
        currentPath.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            allPath.add(new ArrayList<>(currentPath));
        }
        if (root.left != null) {
            findAllPath(root.left, target - root.val);
        }
        if (root.right != null) {
            findAllPath(root.right, target - root.val);
        }
        currentPath.remove(currentPath.size() - 1);
        return;
    }
}
