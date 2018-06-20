package com.algorithm;

/***
 * 实现快速排序
 */
public class QuickSort {


    public static <T extends Comparable> void qsort(T[] vals) {
        if (vals == null || vals.length == 0 || vals.length == 1) {
            return;
        }
        quicksort(vals, 0, vals.length - 1);
    }

    public static <T extends Comparable> void quicksort(T[] vals, int start, int end) {
        if (start >= end) {
            return;
        } else {
            int partition = partition(vals, start, end);
            quicksort(vals, start, partition - 1);
            quicksort(vals, partition + 1, end);
        }
    }

    public static <T extends Comparable> int partition(T[] vals, int start, int end) {
        if (start >= end) {
            return start;
        }
        T temp = vals[end];
        while (start < end) {
            while (start < end && vals[start].compareTo(temp) <= 0)
                ++start;
            vals[end] = vals[start];
            while (start < end && vals[end].compareTo(temp) > 0)
                --end;
            vals[start] = vals[end];
        }
        vals[start] = temp;
        return start;
    }


}
