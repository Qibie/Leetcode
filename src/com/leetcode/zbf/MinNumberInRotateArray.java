package com.leetcode.zbf;

import org.omg.CORBA.ARG_IN;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        int low = 0, high = array.length - 1;
        if(array[low]<array[high]){
            return array[low];
        }

        while (low < high) {
            if(high==low+1){
                return array[high];
            }
            int mid = (low + high) / 2;
            if(array[mid]==array[high] && array[mid]==array[low]){
                return search(array);
            }
            if(array[mid]<array[high]){
                high=mid;
            }else {
                low=mid;
            }
        }
        return array[low];
    }

    public int search(int []array){
        for(int i=array.length-1;i>0;--i){
            if(array[i-1]>array[i]){
                return array[i];
            }
        }
        return array[0];
    }




    public static void main(String[] args) {
        int [] array={1,0,1,1,1};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
    }
}
