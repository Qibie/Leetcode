package com.algorithm;

import com.sun.org.apache.regexp.internal.RE;

import javax.swing.text.TabExpander;
import java.util.Arrays;

/**
 * (
 * // 分类 -------------- 内部比较排序
 * // 数据结构 ---------- 数组
 * // 最差时间复杂度 ---- O(n^2)
 * // 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
 * // 平均时间复杂度 ---- O(n^2)
 * // 所需辅助空间 ------ O(1)
 * // 稳定性 ------------ 稳定
 */
public class BubbleSort {
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void bubbleSort(int A[], int n) {
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
    }

    /* 分类 -------------- 内部比较排序
     数据结构 ---------- 数组
     最差时间复杂度 ---- O(n^2)
     最优时间复杂度 ---- O(n^2)
     平均时间复杂度 ---- O(n^2)
     所需辅助空间 ------ O(1)
     稳定性 ------------ 不稳定*/
    public void cocktailSort(int[] A, int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            //第一次從左到右開始遍歷
            for (int i = left; i < right; ++i) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                }
            }
            --right;
            //第二次從右到左開始遍歷
            for (int j = right; j > left; --j) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                }
            }
            ++left;
        }
    }

    public void selectionSort(int[] A, int n) {
        // 分类 -------------- 内部比较排序
        // 数据结构 ---------- 数组
        // 最差时间复杂度 ---- O(n^2)
        // 最优时间复杂度 ---- O(n^2)
        // 平均时间复杂度 ---- O(n^2)
        // 所需辅助空间 ------ O(1)
        // 稳定性 ------------ 不稳定
        for (int i = 0; i < n - 1; ++i) {
            int max_index = 0;
            for (int j = 1; j < n - i; ++j) {
                if (A[j] > A[max_index]) {
                    max_index = j;
                }
            }
            if (max_index != n - i - 1) {
                swap(A, max_index, n - i - 1);
            }
        }
    }


    public void insertionSort(int[] A, int n) {
        //分类 ------------- 内部比较排序
        // 数据结构 ---------- 数组
        // 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
        // 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
        // 平均时间复杂度 ---- O(n^2)
        // 所需辅助空间 ------ O(1)
        // 稳定性 ------------ 稳定
        for (int i = 1; i < n; ++i) {
            if (A[i - 1] > A[i]) {
                int k = i - 1, temp = A[i];
                while (k >= 0 && A[k] > temp) {
                    A[k + 1] = A[k];
                    --k;
                }
                A[k + 1] = temp;
            }
        }
    }


    public void shellSort(int[] A, int n) {
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;// <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        }
        while (h >= 1) {
            for (int i = 0; i < h; i += 1) {
                for (int j = i + h; j < n; j += h) {
                    if (A[j - h] > A[j]) {
                        int temp = A[j], k = j - h;
                        while (k >= 0 && A[k] > temp) {
                            A[k + h] = A[k];
                            k -= h;
                        }
                        A[k + h] = temp;
                    }
                }
            }
            h = (h - 1) / 3;
        }

    }


    public void merge(int[] A, int[] temp, int left, int mid, int right) {
        int right_begin = mid + 1, k = left, left_begin = left;
        while (left_begin <= mid && right_begin <= right) {
            if (A[left_begin] < A[right_begin]) {
                temp[k++] = A[left_begin++];
            } else {
                temp[k++] = A[right_begin++];
            }
        }
        while (left_begin <= mid) {
            temp[k++] = A[left_begin++];
        }
        while (right_begin <= right) {
            temp[k++] = A[right_begin++];
        }
        for (k = left; k <= right; ++k) {
            A[k] = temp[k];
        }
    }


    public void MergeSortRecursion(int[] A, int[] temp, int left, int right) {
        if (left == right) {
            return;
        } else {
            int mid = (left + right) / 2;
            MergeSortRecursion(A, temp, left, mid);
            MergeSortRecursion(A, temp, mid + 1, right);
            merge(A, temp, left, mid, right);
        }
    }

    public void mergeSortInterable(int[] A, int[] temp) {
        int len = A.length, left = 0, mid = 0, right = 0;
        for (int i = 1; i < len; i *= 2) {
            left = 0;
            while (left + i < len) {
                mid = left + i - 1;
                right = mid + i > len ? len - 1 : mid + i;
                merge(A, temp, left, mid, right);
                left = right + 1;
            }
        }

    }


    public void heapAdjustRecursion(int[] A, int i, int size) {
        int left = 2 * i + 1, right = left + 1, k = i;
        if (left <= size && A[left] > A[k]) {
            k = left;
        }
        if (right <= size && A[right] > A[k]) {
            k = right;
        }
        if (k != i) {
            swap(A, i, k);
            heapAdjustRecursion(A, k, size);
        }
    }

    public void headAdjustIterable(int[] A, int i, int size) {
        int k = 2 * i + 1;
        while (k <= size) {
            if (k < size) {
                if (A[k + 1] > A[k]) {
                    k++;
                }
                if (A[k] > A[i]) {
                    swap(A, i, k);
                    i = k;
                    k = 2 * i + 1;
                }
            } else {
                break;
            }
        }
    }


    /**
     * 创建最大堆
     *
     * @param A
     * @param size
     */
    public void buildHeap(int[] A, int size) {
        for (int i = (size / 2 - 1); i >= 0; --i) {
            headAdjustIterable(A, i, size);
        }
    }

    public void heapsort(int[] A, int size) {
        buildHeap(A, size);
        swap(A, 0, size);
        for (int i = size - 1; i > 0; --i) {
            headAdjustIterable(A, 0, i);
            swap(A, 0, i);
        }
    }


    /**
     * quick sort
     * @param A
     * @param left
     * @param right
     * @return
     */
    public int patition(int[] A, int left, int right) {
        int temp=A[right];
        while (left<right){
            while (left<right && A[left]<temp){
                ++left;
            }
            A[right]=A[left];
            while (left<right&& A[right]>=temp){
                --right;
            }
            A[left]=A[right];
        }
        A[left]=temp;
        return left;
    }


    public void quickSort(int []A,int left,int right){
       if (left<right){
           int privot=patition(A,left,right);
           quickSort(A,left,privot-1);
           quickSort(A,privot+1,right);
       }
    }



    public static void main(String[] args) {
        int[] A = {20, 50, 20, 40, 70, 10, 80, 30, 60};
        int[] temp = new int[A.length];
        new BubbleSort().quickSort(A, 0,A.length - 1);
        System.out.println(Arrays.toString(A));
    }

}
//