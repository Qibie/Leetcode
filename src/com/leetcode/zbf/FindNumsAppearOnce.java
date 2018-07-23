package com.leetcode.zbf;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitresult = 0, index = 0;
        num1[0] = num2[0] = 0;
        for (int i = 0; i < length; ++i) {
            bitresult = bitresult ^ array[i];
        }
        while ((bitresult & 1) != 1 && index < 32) {
            bitresult = bitresult >> 1;
            ++index;
        }
        for (int i = 0; i < length; ++i) {
            if ((array[i] >> index & 1) == 1) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }


    }
}
