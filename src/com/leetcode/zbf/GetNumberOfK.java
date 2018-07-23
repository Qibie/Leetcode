package com.leetcode.zbf;

import com.sun.org.apache.regexp.internal.RE;

import java.io.File;

public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firtIndex = GetFirstKIndex(array, k, 0, array.length - 1), lastIndex = GetLastKIndex(array, k, 0, array.length - 1);
        if (firtIndex != -1 && lastIndex != -1 && firtIndex <= lastIndex) {
            return lastIndex - firtIndex + 1;
        }
        return 0;
    }

    public int GetFirstKIndex(int[] array, int k, int low, int high) {
        if (low > high) {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == low || array[mid - 1] != k) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        if (low > high) {
            return -1;
        }
        return low;
    }

    public int GetLastKIndex(int[] array, int k, int low, int high) {
        if (low > high) {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                if (mid == high || array[mid + 1] != k) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        if (low > high) {
            return -1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 3, 3, 3, 4, 5};
        System.out.println(new GetNumberOfK().GetNumberOfK(array, 3));
    }
}
