package com.leetcode.zbf;

import com.algorithm.QuickSort;

import java.util.stream.StreamSupport;

public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        if (numbers.length == 1) {
            return numbers[0] + "";
        }
        String[] numberStrs = new String[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            numberStrs[i] = numbers[i] + "";
        }
        qsort(numberStrs);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : numberStrs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }


    public void qsort(String[] strings) {
        if (strings == null || strings.length == 0 || strings.length == 1) {
            return;
        }
        quicksort(strings, 0, strings.length - 1);
    }

    public void quicksort(String[] strings, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(strings, start, end);
        quicksort(strings, start, partition - 1);
        quicksort(strings, partition + 1, end);
    }

    public int partition(String[] strings, int start, int end) {
        if (start >= end) {
            return start;
        }
        String temp = strings[start];
        while (start < end) {
            while (start < end && compareStr(strings[end],temp) > 0)
                --end;
            strings[start] = strings[end];
            while (start < end && compareStr(strings[start],temp) <= 0)
                ++start;
            strings[end] = strings[start];
        }
        strings[start] = temp;
        return start;
    }


    public int compareStr(String string1, String string2) {
        String merge1 = string1 + string2, merge2 = string2 + string1;
        return merge1.compareTo(merge2);

    }


    public static void main(String[] args) {
        System.out.println(new PrintMinNumber().PrintMinNumber(new int[]{1,2,3,4,5}));
    }
}
