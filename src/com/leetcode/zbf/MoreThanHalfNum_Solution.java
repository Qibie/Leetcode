package com.leetcode.zbf;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum_Solution {
//    public int MoreThanHalfNum_Solution(int[] array) {
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        if (array.length == 1) {
//            return array[0];
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        int n = array.length / 2;
//        for (int i = 0; i < array.length; ++i) {
//            if (map.containsKey(array[i])) {
//                map.put(array[i],map.get(array[i])+1);
//            } else {
//                map.put(array[i], +1);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > n) {
//                return entry.getKey();
//            }
//        }
//        return 0;
//    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int times = 1, result = array[0];
        for (int i = 0; i < array.length; ++i) {
            if (times == 0) {
                result = array[i];
                ++times;
            } else {
                if (result == array[i]) {
                    ++times;
                } else {
                    --times;
                }
            }
        }
        if (times == 0) {
            return 0;
        }
        times = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == result) {
                ++times;
            }
        }
        if (times > (array.length >> 1)) {
            return result;
        }
        return 0;
    }
}