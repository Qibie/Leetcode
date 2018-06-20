package com.leetcode.zbf;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

public class GreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int greatSum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
            if (sum > greatSum) {
                greatSum = sum;
            }
            if (sum <= 0) {
                sum = 0;
                continue;
            }
        }
        return greatSum;
    }


    public static void main(String[] args) {

    }
}
