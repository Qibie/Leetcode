package com.leetcode.zbf;

import java.util.LinkedList;

public class SerializeTree {
    String Serialize(TreeNode root) {
        if (root == null)
            return "*";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val);
        stringBuilder.append(",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(",");
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == "*")
            return null;
        String[] strings = str.split(",");
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        int length = str.length();
        TreeNode nullFlagNode = new TreeNode(-1), head = new TreeNode(Integer.parseInt(strings[0]));
        treeNodes.addLast(head);
        for (int i = 1; i < strings.length; ++i) {
            TreeNode treeNode = treeNodes.getLast();
            if (strings[i].equals("*")) {
                if (treeNode.left == null)
                    treeNode.left = nullFlagNode;
                else
                    treeNodes.removeLast();
                continue;
            }
            if (treeNode.left == null) {
                treeNode.left = new TreeNode(Integer.parseInt(strings[i]));
                treeNodes.addLast(treeNode.left);
            } else {
                treeNode.right = new TreeNode(Integer.parseInt(strings[i]));
                treeNodes.removeLast();
                treeNodes.addLast(treeNode.right);
            }
        }

        removeFlagNode(head, nullFlagNode);
        return head;
    }

    void removeFlagNode(TreeNode treeNode, TreeNode flagNode) {
        if (treeNode == null)
            return;
        if (treeNode.left != null) {
            if (treeNode.left == flagNode)
                treeNode.left = null;
            else removeFlagNode(treeNode.left, flagNode);
        }
        if (treeNode.right != null) {
            if (treeNode.right == flagNode)
                treeNode.right = null;
            else removeFlagNode(treeNode.right, flagNode);
        }
    }


    private int start = 1;

    TreeNode Deserialize_recurrsion(String str) {
        if (str == "*")
            return null;
        String[] strings = str.split(",");
        TreeNode head = new TreeNode(Integer.parseInt(strings[0]));
        head.left = Deserialize_recurrsion(strings);
        head.right = Deserialize_recurrsion(strings);
        return head;
    }

    public TreeNode Deserialize_recurrsion(String[] strings) {
        if (start >= strings.length) {
            return null;
        }
        TreeNode treeNode = null;
        if (!strings[start].equals("*")) {
            treeNode = new TreeNode(Integer.parseInt(strings[start++]));
            treeNode.left = Deserialize_recurrsion(strings);
            treeNode.right = Deserialize_recurrsion(strings);
        }else {
            ++start;
        }
        return treeNode;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        treeNode1.left = new TreeNode(6);
        treeNode1.right = new TreeNode(14);
        treeNode1.left.left = new TreeNode(4);
        treeNode1.left.right = new TreeNode(8);
        treeNode1.right.left = new TreeNode(12);
        treeNode1.right.right = new TreeNode(16);
        String str = new SerializeTree().Serialize(treeNode1);
        System.out.println(new SerializeTree().Deserialize_recurrsion(str));
    }
}
