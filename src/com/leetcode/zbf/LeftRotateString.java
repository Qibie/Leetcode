package com.leetcode.zbf;

public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (n == 0 || n % str.length() == 0) {
            return str;
        }
        return str.substring(n) + str.substring(0, n);
    }
}
