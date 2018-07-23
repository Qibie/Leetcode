package com.leetcode.zbf;

import java.util.ArrayList;

public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        ArrayList<Integer> result = new ArrayList<Integer>() {{
            for (int i = 0; i < n; ++i) {
                add(i);
            }
        }};
        int temp_size = 0, temp_index = 0;
        while (result.size() > 1) {
            temp_size = result.size();
            temp_index = temp_index + ((m-1) % temp_size);
            if (temp_index >= temp_size)
                temp_index -= temp_size;
            result.remove(temp_index);
        }
        return result.get(0);
    }


    public static void main(String[] args) {
        System.out.println(new LastRemaining_Solution().LastRemaining_Solution(5, 3));
//        System.out.println(5%3);
    }
}
