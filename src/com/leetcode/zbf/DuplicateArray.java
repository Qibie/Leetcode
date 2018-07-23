package com.leetcode.zbf;

import java.util.HashMap;

public class DuplicateArray {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false\

    /**
     * 额外辅助空间
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 1) {
            return false;
        }
        int[] countArray = new int[length];
        for (int i = 0; i < length; ++i) {
            countArray[numbers[i]]++;
            if (countArray[numbers[i]] > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 不需要额外辅助空间
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 1) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false;
    }


    public static void main(String[] args) {
        new DuplicateArray().duplicate(new int[10], 10, new int[1]);
    }
}
