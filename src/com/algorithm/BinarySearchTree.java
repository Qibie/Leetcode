package com.algorithm;

import com.leetcode.zbf.TreeNode;

public class BinarySearchTree {

    TreeNode root;


    public BinarySearchTree() {
        InsertTree_Recursion(5);
        InsertTree_Recursion(3);
        InsertTree_Recursion(7);
        InsertTree_Recursion(1);
        InsertTree_Recursion(4);
        InsertTree_Recursion(6);
        InsertTree_Recursion(8);
        InsertTree_Recursion(0);
        InsertTree_Recursion(2);
        InsertTree_Recursion(9);
    }


    /**
     * 插入非递归
     *
     * @param val
     */
    public void InserTree(int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        TreeNode cur = root, pre = cur;
        while (cur != null) {
            pre = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                return;
            }
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
    }


    public TreeNode InsertTree_Recursion(int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (root.val > val) {
                root.left = InsertTree_Recursion(root.left, val);
            } else if (root.val < val) {
                root.right = InsertTree_Recursion(root.right, val);
            }
        }
        return root;
    }


    public TreeNode InsertTree_Recursion(TreeNode treeNode, int val) {
        if (treeNode == null) {
            treeNode = new TreeNode(val);
            return treeNode;
        }
        if (treeNode.val > val) {
            treeNode.left = InsertTree_Recursion(treeNode.left, val);
        } else if (treeNode.val < val) {
            treeNode.right = InsertTree_Recursion(treeNode.right, val);
        }
        return treeNode;
    }

    /**
     * 查找迭代版本
     *
     * @param val
     * @return
     */
    public TreeNode Search_Iterable(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }


    /**
     * 查找递归版本
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode Search_Recurrsion(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return Search_Recurrsion(root.left, val);
        } else {
            return Search_Recurrsion(root.right, val);
        }

    }


    /**
     * 删除迭代版本
     *
     * @param val
     * @return
     */
    public boolean Delete_Iterable(int val) {
        if (root == null) {
            return false;
        }
        TreeNode parent = null, cur = root;
        while (cur != null && cur.val != val) {
            parent = cur;
            if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        //不存在要删除的节点
        if (cur == null) {
            return false;
        }

        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else if (cur.right != null && cur.left != null) {
            parent = cur;
            TreeNode temp = cur.right;
            while (temp.left != null) {
                parent = temp;
                temp = temp.left;
            }
            cur.val = temp.val;
            if (parent.left == temp) {
                parent.left = temp.right;
            } else {
                parent.right = temp.right;
            }
        }
        return true;
    }

    public int size() {
        return size(root);
    }

    public int size(TreeNode treeNode) {
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


    private int height() {
        return height(root);
    }

    /**
     * 获取当前节点的高度
     *
     * @param avlTreeNode
     * @return
     */
    private int height(TreeNode avlTreeNode) {
        TreeNode temp = avlTreeNode;
        if (temp == null) {
            return -1;
        }
        if (temp.left == null && temp.right == null) {
            return 0;
        }
        return Math.max(height(temp.left), height(temp.right)) + 1;
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println(binarySearchTree.root);
        System.out.println(binarySearchTree.size());
        binarySearchTree.Delete_Iterable(9);
        System.out.println(binarySearchTree.root);
        System.out.println(binarySearchTree.size());
        System.out.println(binarySearchTree.height());

    }

}
