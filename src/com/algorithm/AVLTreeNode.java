package com.algorithm;

/**
 * 平衡二叉树节点
 * @param <T>
 */
public class AVLTreeNode<T extends Comparable> {
    public AVLTreeNode<T> left = null;
    public AVLTreeNode<T> right = null;
    public T val;
    public int height;//当前结点的高度

    public AVLTreeNode(AVLTreeNode<T> left, AVLTreeNode<T> right, T val, int height) {
        this.left = left;
        this.right = right;
        this.val = val;
        this.height = height;
    }

    public AVLTreeNode(AVLTreeNode<T> left, AVLTreeNode<T> right, T val) {
        this(left, right, val, 0);
    }

    public AVLTreeNode(T val) {
        this(null, null, val);
    }




}
