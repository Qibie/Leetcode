package com.leetcode.zbf;


import java.util.ArrayList;
import java.util.TreeSet;

public class GetLeastNumbers_Solution {
//    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
//        if (input == null || input.length == 0) {
//            return new ArrayList<Integer>();
//        }
//        if (input.length <= k) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int in : input) {
//                list.add(in);
//            }
//            return list;
//        }
//        int mid = partition(input, 0, input.length - 1);
//        --k;
//        while (mid != k) {
//            if (mid > k) {
//                mid = partition(input, 0, mid - 1);
//            } else {
//                mid = partition(input, mid + 1, input.length - 1);
//            }
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i <= k; ++i) {
//            list.add(input[i]);
//        }
//        return list;
//    }

//    public int partition(int[] input, int start, int end) {
//        if (start >= end) {
//            return start;
//        }
//        int temp = input[end];
//        while (start < end) {
//            while (start < end && input[start] <= temp)
//                ++start;
//            input[end] = input[start];
//            while (start < end && input[end] > temp)
//                --end;
//            input[start] = input[end];
//        }
//        input[start] = temp;
//        return start;
//    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if (k > input.length) {
            return list;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : input) {
            treeSet.add(i);
        }
        int i = 0;
        for (int num : treeSet) {
            if (i >= k) {
                break;
            }
            list.add(num);
            ++i;
        }
        return list;
    }


    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> list = new GetLeastNumbers_Solution().GetLeastNumbers_Solution(array, 4);
        System.out.println("fsdfsd");
    }
}
