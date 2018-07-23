package com.leetcode.zbf;

public class Sum_Solution {
    int result = 0;

    public int Sum_Solution(int n) {
        cal(n);
        return result;
    }

    public boolean cal(int n) {
        result += n;
        return (n != 0) && (cal(n - 1));
    }


}
