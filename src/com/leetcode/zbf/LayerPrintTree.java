package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.LinkedList;

public class LayerPrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp_list = new ArrayList<>();
        queue.addLast(pRoot);
        queue.addLast(null);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                result.add(temp_list);
                temp_list = new ArrayList<Integer>();
                if (queue.size() > 0)
                    queue.addLast(null);
                continue;
            }
            temp_list.add(temp.val);
            if (temp.left != null)
                queue.addLast(temp.left);
            if (temp.right != null)
                queue.addLast(temp.right);
        }
        return result;
    }
}
