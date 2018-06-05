package com.leetcode.zbf;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x ){ val=x;}

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        if(left!=null){
            stringBuilder.append(left.toString());
        }
        stringBuilder.append(val);
        if(right!=null){
            stringBuilder.append(right.toString());
        }
        return stringBuilder.toString();
    }
}


public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || in ==null || pre.length==0 || in.length==0){
            return null;
        }
        if(pre.length ==1){
            return new TreeNode(pre[0]);
        }else {
            return constructBinaryTree(pre,in);
        }

    }

    public  TreeNode constructBinaryTree(int []pre,int [] in ){
        if (pre.length==1){
            return new TreeNode(pre[0]);
        }
        TreeNode treeNode=new TreeNode(pre[0]);
        int index=0;
        for (;index<in.length;++index){
            if(in[index]==pre[0]){
                break;
            }
        }
        int [] left_pre=new int[index], left_in=new int[index],right_pre=new int[pre.length-index-1],right_in=new int[pre.length-index-1];
        for(int i=1;i<=index;++i){
            left_pre[i-1]=pre[i];
            left_in[i-1]=in[i-1];
        }
        for(int i=0;i<right_in.length;++i){
            right_pre[i]=pre[i+index+1];
            right_in[i]=in[i+index+1];
        }
        if(left_pre.length>0) {
            treeNode.left = constructBinaryTree(left_pre, left_in);
        }
        if(right_pre.length>0) {
            treeNode.right = constructBinaryTree(right_pre, right_in);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8},in={4,7,2,1,5,3,8,6};
        System.out.println(new ReConstructBinaryTree().constructBinaryTree(pre,in));
    }
}
