package com.leetcode.zbf;

import java.util.Stack;

public class InOrderGetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        /**
         if (pNode == null) {
         return null;
         }
         Stack<TreeLinkNode> stack = new Stack<>();
         TreeLinkNode linkNode = pNode, currnode = null;
         while (linkNode.next != null) {
         linkNode = linkNode.next;
         }
         while (linkNode != null || !stack.isEmpty()) {
         if (linkNode != null) {
         stack.push(linkNode);
         linkNode = linkNode.left;
         } else {
         linkNode = stack.pop();
         if (currnode == pNode) {
         return linkNode;
         }
         currnode = linkNode;
         linkNode = linkNode.right;
         }
         }
         return null;
         */

        if (pNode == null)
            return null;
        TreeLinkNode node = pNode;
        if (node.right != null) {
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (node.next != null) {
                if (node.next.left == node)
                    return node.next;
                node = node.next;
            }
        }
        return null;
    }
}
