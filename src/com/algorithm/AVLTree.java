package com.algorithm;

import com.leetcode.zbf.TreeNode;
import com.leetcode.zbf.ValidParentheses;

import java.lang.reflect.TypeVariable;

public class AVLTree<T extends Comparable> {


    private AVLTreeNode<T> root;

    /**
     * check the tree empty or not
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null ? true : false;
    }

    /**
     * get nodes number of whole tree
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    public int size(AVLTreeNode<T> treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        }
        int size = 1;
        if (treeNode.left != null) {
            size += size(treeNode.left);
        }
        if (treeNode.right != null) {
            size += size(treeNode.right);
        }
        return size;
    }


    /**
     * LL single rotation
     *
     * @param x
     * @return
     */
    private AVLTreeNode<T> singleRotateLeft(AVLTreeNode<T> x) {
        AVLTreeNode<T> w = x.left;
        x.left = w.right;
        w.right = x;
        x.height = height(x);
        w.height = height(w);
        return w;
    }


    /**
     * RR single rotation
     *
     * @param w
     * @return
     */
    private AVLTreeNode<T> singleRotateRight(AVLTreeNode<T> w) {
        AVLTreeNode<T> x = w.right;
        w.right = x.left;
        x.left = w;
        x.height = height(x);
        w.height = height(w);
        return x;
    }


    /**
     * 左右旋转(LR旋转) x(根) w y 结点 把y变成根结点
     *
     * @param x
     * @return
     */
    private AVLTreeNode<T> doubleRotateWithLeft(AVLTreeNode<T> x) {
        x.left = singleRotateRight(x.left);
        return singleRotateLeft(x);
    }


    /**
     * 右左旋转（RL）
     *
     * @param x
     * @return
     */
    private AVLTreeNode<T> doubleRotateWithRight(AVLTreeNode<T> x) {
        x.right = singleRotateLeft(x.left);
        return singleRotateRight(x);
    }


    private int height() {
        return height(root);
    }

    /**
     * 获取当前节点的高度
     *
     * @param avlTreeNode
     * @return
     */
    private int height(AVLTreeNode<T> avlTreeNode) {
        AVLTreeNode<T> temp = avlTreeNode;
        if (temp == null) {
            return -1;
        }
        if (temp.left == null && temp.right == null) {
            return 0;
        }
        return Math.max(height(temp.left), height(temp.right)) + 1;
    }


    /**
     * 找到最小的节点
     *
     * @return
     */
    private AVLTreeNode<T> findmin() {
        return findmin(root);
    }

    private AVLTreeNode<T> findmin(AVLTreeNode<T> treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left == null) {
            return treeNode;
        }
        return findmin(treeNode.left);
    }

    /**
     * 找到最小的值
     *
     * @param treeNode
     * @return
     */
    private T findminval(AVLTreeNode<T> treeNode) {
        if (treeNode == null) {
            throw new RuntimeException("fuck you");
        }
        return findmin(treeNode).val;
    }

    private T findminval() {
        if (root == null) {
            throw new RuntimeException("fuck you");
        }
        return findmin().val;
    }


    /**
     * 插入节点
     *
     * @param val
     */
    public void insert(T val) {
        if (val == null) {
            throw new RuntimeException("FUCK YOU");
        }
        if (root == null) {
            root = new AVLTreeNode<T>(val);
        } else if (root.val.compareTo(val) > 0) {
            root.left = insert(root.left, val);
        } else if (root.val.compareTo(val) < 0) {
            root.right = insert(root.right, val);
        }
    }


    public AVLTreeNode<T> insert(AVLTreeNode<T> treeNode, T val) {
        if (treeNode == null) {
            treeNode = new AVLTreeNode<T>(val);
        }
        if (treeNode.val.compareTo(val) > 0) {
            treeNode.left = insert(treeNode.left, val);
            if (height(treeNode.left) - height(treeNode.right) == 2) {
                if (treeNode.left.val.compareTo(val) > 0) {
                    singleRotateLeft(treeNode);
                } else {
                    doubleRotateWithLeft(treeNode);
                }
            }
        } else if (treeNode.val.compareTo(val) < 0) {
            treeNode.right = insert(treeNode.right, val);
            if (height(treeNode.right) - height(treeNode.left) == 2) {
                if (treeNode.right.val.compareTo(val) < 0) {
                    singleRotateRight(treeNode);
                } else {
                    doubleRotateWithRight(treeNode);
                }
            }
        }

        treeNode.height = height(treeNode);
        return treeNode;
    }


    /**
     * 刪除一个节点
     *
     * @param val
     */
    public void remove(T val) {
        if (val == null) {
            return;
        }
        if (root == null) {
            return;
        }
        root = remove(root, val);
    }

    public AVLTreeNode<T> remove(AVLTreeNode<T> treeNode, T val) {
        if (treeNode == null) {
            return null;
        }
        int result = treeNode.val.compareTo(val);
        if (result > 0) {//从左子树删除节点
            treeNode.left = remove(treeNode.left, val);
            if (height(treeNode.right) - height(treeNode.left) == 2) {
                //如果发生不平衡，肯定是右子树，因为是左子树删除的节点,而且之前是平衡的，不平衡的时候，相差只能是2
                AVLTreeNode<T> cur = treeNode.right;
                //注意这里，cur肯定非空，因为右子树比左子树高度高2
                if (height(cur.left) > height(cur.right)) {
                    //说明是RL
                    treeNode = doubleRotateWithRight(treeNode);
                } else {
                    //说明是RR
                    treeNode = singleRotateRight(treeNode);
                }
            }
        } else if (result < 0) {//右子树删节点
            treeNode.right = remove(treeNode.right, val);
            if (height(treeNode.left) - height(treeNode.right) == 2) {
                //如果发生不平衡，肯定是左子树，因为右子树删除的节点，之前是平衡的，所以高度差只能是2
                AVLTreeNode<T> cur = treeNode.left;
                //cur肯定不为空，因为左子树比右子树高2
                if (height(cur.left) > height(cur.right)) {
                    //说明是LL
                    treeNode = singleRotateLeft(treeNode);
                } else {
                    treeNode = doubleRotateWithLeft(treeNode);
                }
            }
            //当前节点就是应该删除的节点
        } else if (treeNode.left != null && treeNode.right != null) {
            treeNode.val = findminval(treeNode.right);
            treeNode.right = remove(treeNode.right, treeNode.val);
        } else {
            //只有左子树或者只有右子树
            treeNode = (treeNode.left == null ? treeNode.right : treeNode.left);
        }
        if (treeNode != null) {
            treeNode.height = height(treeNode);
        }
        return treeNode;
    }


    @Override
    public String toString() {
        return inerOrder(root);
    }

    /**
     * 中序遍歷
     *
     * @param treeNode
     * @return
     */
    public String inerOrder(AVLTreeNode<T> treeNode) {
        StringBuilder stringBuilder = new StringBuilder();
        if (treeNode.left != null) {
            stringBuilder.append(inerOrder(treeNode.left));
        }
        stringBuilder.append(treeNode.val.toString());
        if (treeNode.right != null) {
            stringBuilder.append(inerOrder(treeNode.right));
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(0);
        tree.insert(2);
        tree.insert(9);
        System.out.println(tree);
        System.out.println(tree.size());

        tree.remove(7);
        System.out.println(tree);
        System.out.println(tree.size());

    }
}
