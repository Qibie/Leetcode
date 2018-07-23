package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 2) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = 2;
        while (sum >= ((n * (n + 1)) >> 1))
            ++n;
        --n;


        while (sum >= ((n * (n + 1)) >> 1) && n >= 2) {
            int multiply = sum - ((n * (n - 1)) >> 1);
            if (multiply % n == 0) {
                ArrayList<Integer> nResult = new ArrayList<>();
                int startNum = multiply / n;
                for (int i = 0; i < n; ++i) {
                    nResult.add(startNum + i);
                }
                result.add(nResult);
            }
            --n;
        }
        return result;
    }


    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length <= 1 || sum < (array[0] + array[1])) {
            return new ArrayList<Integer>();
        }
        int start = 0, end = array.length - 1;
        int[] result = new int[2];
        boolean isFirst = true, find = false;
        while (start < end) {
            int temp_sum = array[start] + array[end];
            if (temp_sum == sum) {
                if (isFirst || (result[0] * result[1]) > (array[start] * array[end])) {
                    result[0] = array[start];
                    result[1] = array[end];
                    isFirst = false;
                    find = true;
                }
                ++start;
                --end;
            } else if (temp_sum > sum) {
                --end;
            } else {
                ++start;
            }

        }
        if (find) {
            return new ArrayList<Integer>() {{
                add(result[0]);
                add(result[1]);
            }};
        } else {
            return new ArrayList<>();
        }
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence_point(int sum) {
        if (sum <= 2) {
            return new ArrayList<>();
        }
        int start = 1, end = 2;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        while (start < end && end < sum) {
            if (getSum(start, end) < sum)
                ++end;
            else if (getSum(start, end) > sum)
                ++start;
            else {
                ArrayList<Integer> list = new ArrayList();
                for (int i = start; i <= end; ++i) {
                    list.add(i);
                }
                arrayLists.add(list);
                ++end;
            }
        }
        return arrayLists;
    }


    public int getSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; ++i) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().FindContinuousSequence_point(100));
    }
}
