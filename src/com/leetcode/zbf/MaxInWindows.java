package com.leetcode.zbf;


import java.util.ArrayList;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        int length = num.length;
        ArrayList<Integer> result = new ArrayList<>();
        if (size >= length) {
            result.add(num[getMaxIndex(num, 0, length - 1)]);
            return result;
        }
        int max = getMaxIndex(num, 0, size - 1);
        result.add(num[max]);
        for (int i = size; i < num.length; ++i) {
            if (max > i || max <= (i - size)) {
                max = getMaxIndex(num, i - size + 1, i);
            } else {
                if (num[max] < num[i]) {
                    max = i;
                }
            }
            result.add(num[max]);
        }
        return result;
    }

    public int getMaxIndex(int[] num, int start, int end) {
        if (start > end)
            return -1;
        if (start == end)
            return start;
        int max = start;
        for (int i = start + 1; i <= end; ++i) {
            if (num[i] > num[max]) {
                max = i;
            }
        }
        return max;
    }


}
