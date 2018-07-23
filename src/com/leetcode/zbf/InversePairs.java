package com.leetcode.zbf;

import java.math.BigInteger;

public class InversePairs {
    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int count = MergeSort(array, 0, array.length - 1);
        return count % 1000000007;
    }


    public int MergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int[] array_copy = new int[end - start + 1];
        int count = 0, mid = (start + end) / 2, end_before = mid, end_after = end, step = array_copy.length - 1;
        count += MergeSort(array, start, mid);
        count += MergeSort(array, mid + 1, end);
        while (end_before >= start && end_after >= mid + 1) {
            if (array[end_after] > array[end_before]) {
                array_copy[step--] = array[end_after--];
            } else {
                count += (end_after - mid);
                array_copy[step--] = array[end_before--];
            }
        }
        while (end_before >= start) {
            array_copy[step--] = array[end_before--];
        }
        while (end_after >= mid + 1) {
            array_copy[step--] = array[end_after--];
        }

        for (int i = start; i <= end; ++i) {
            array[i] = array_copy[i - start];
        }
        return count;
    }

    public static void main(String[] args) {
        int [] array=new int[]{3,4,5,1,2,7};
        System.out.println(new InversePairs().InversePairs(array));
    }
}
