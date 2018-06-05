package com.leetcode.zbf;


public class dyadicarray {
    /**
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        if(array==null){
            return false;
        }
        int m=array.length,n=array[0].length;
        if(m==0 || n==0){
            return false;
        }
        if(target<array[0][0]|| target>array[m-1][n-1]){
            return false;
        }
        int row=0,colomn=n-1;
        while (row<m &&colomn>=0){
            if(array[row][colomn]==target){
                return  true;
            }else if(array[row][colomn]>target){
                colomn--;
            }else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int [][]array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int [][]array={{}};
        System.out.println(new dyadicarray().Find(1,array));
    }

}
