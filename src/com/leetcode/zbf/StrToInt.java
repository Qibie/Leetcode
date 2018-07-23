package com.leetcode.zbf;

import sun.nio.cs.ext.ISCII91;

public class StrToInt {


    /**
     * 考虑的情况
     * 1、空，
     * 2、开头正负号，
     * 3、非正负号和数字 字符
     * 4、 越界
     *
     * @param str
     * @return
     */

    public int StrToInt(String str) {
        //空
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isNegative = false;
        int cutoff = Integer.MAX_VALUE / 10, result = 0, boundary = Integer.MAX_VALUE, beginIndex = 0, mod;
        //开头正负号
        if (str.charAt(0) == '-') {
            isNegative = true;
            boundary = Integer.MIN_VALUE;
            ++beginIndex;
        } else if (str.charAt(0) == '+') {
            ++beginIndex;
        } else if (str.charAt(0) > '9' || str.charAt(0) < '0') {
            //非数字字符
            return 0;
        }
        mod = Math.abs(boundary % cutoff);
        for (int i = beginIndex; i < str.length(); ++i) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                return 0;
            }
            if (result < cutoff || (result == cutoff && (str.charAt(i) - '0') <= mod))
                result = result * 10 + (str.charAt(i) - '0');
            else
                return boundary;
        }
        return isNegative?-result:result;
    }


    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("1a33"));
    }
}
