package com.algorithm;

import org.omg.IOP.ComponentIdHelper;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

/**
 * Created by curry on 2018/2/20.
 */
public class SortClass {
    /**
     * 比较
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 打印
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < a.length; ++i) {
            stringBuilder.append(a[i] + ",");
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "]");
        System.out.println(stringBuilder);
    }

    /**
     * 判断是否已经有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; ++i) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 选择排序
     *
     * @param a
     */
    public static void SelectionSort(Comparable[] a) {
        for (int i = 0; i < (a.length - 1); ++i) {
            int min = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void InsertionSort(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); --j) {
                exch(a, j, j - 1);
            }
        }
    }


    public static void CocktailSort(Comparable[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            for (int i = left; i < right; ++i) {
                if (less(a[i + 1], a[i])) {
                    exch(a, i, i + 1);
                }
            }
            --right;
            for (int i = right; i > left; --i) {
                if (less(a[i], a[i - 1])) {
                    exch(a, i, i - 1);
                }
            }
            ++left;
        }
    }

    /**
     * 希尔排序
     *
     * @param a
     */
    public static void ShellSort(Comparable[] a) {
        int N = a.length, h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; ++i) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }

    }

    /**
     * 二分插入排序
     *
     * @param a
     */
    public static void InsertionSortDichotomy(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (less(a[i], a[i - 1])) {
                int left = 0, right = i - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (less(a[mid], a[i])) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                Comparable T = a[i];
                for (int j = i; j > left; --j) {
                    exch(a, j, j - 1);
                }
                a[left] = T;
            }
        }
    }


    /**
     * 快速排序
     *
     * @param a
     * @param low
     * @param high
     * @return
     */

    public static int Partition(Comparable[] a, int low, int high) {
        Comparable T = a[low];
        while (low < high) {
            while (low < high && less(T, a[high])) {
                --high;
            }
            a[low] = a[high];
            while (low < high && less(a[low], T)) {
                ++low;
            }
            a[high] = a[low];
        }
        a[low] = T;
        return low;
    }


    /**
     * 快速排序
     *
     * @param a
     */
    public static void QuickSort(Comparable[] a, int low, int high) {
        if (low < high) {
            int pivot = Partition(a, low, high);
            QuickSort(a, low, pivot - 1);
            QuickSort(a, pivot + 1, high);
        }
    }


    public static void MergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        MergeSortRecurrsion(array, 0, array.length - 1);
    }

    public static void MergeSortRecurrsion(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        MergeSortRecurrsion(array, start, mid);
        MergeSortRecurrsion(array, mid + 1, end);
        int[] array_copy = new int[end - start + 1];
        int step = 0, start_before = start, start_after = mid + 1;
        while (start_before <= mid && start_after <= end) {
            array_copy[step++] = (array[start_before] <= array[start_after]) ? array[start_before++] : array[start_after++];
        }
        while (start_before <= mid) {
            array_copy[step++] = array[start_before++];
        }
        while (start_after <= end) {
            array_copy[step++] = array[start_after++];
        }
        for (int i = start; i <= end; ++i) {
            array[i] = array_copy[i - start];
        }
    }

    public static void main(String[] args) {
        int [] a = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        MergeSort(a);
        System.out.println(Arrays.toString(a));
    }

}
