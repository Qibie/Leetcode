package com.algorithm;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

/**
 * 位运算实现加减乘除
 */
public class BitOperation {

    /**
     * 递归实现加法
     *
     * @param a
     * @param b
     * @return
     */
    public static int addRecurrsion(int a, int b) {
        return b == 0 ? a : addRecurrsion(a ^ b, (a & b) << 1);
    }

    /**
     * 加法非递归
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int ans = a ^ b;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return a;
    }


    public static int negative(int a) {
        return add(~a, 1);
    }

    /**
     * 减法
     *
     * @param a
     * @param b
     * @return
     */
    public static int Minus(int a, int b) {
        return add(a, negative(b));
    }


    /**
     * 正数乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int Multi_pos(int a, int b) {
        int ans = 0;
        while (b != 0) {
            //说明b是奇数,当b为1的时候，将所有的结果加起來
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a = a << 1;
            b = b >> 1;
        }
        return ans;
    }


    /**
     * 正数除法
     * a>0 && b>0
     *
     * @param a
     * @param b
     * @return
     */
    public static int Divide_pos(int a, int b) {
        if (IsZero(b)) {
            throw new ArithmeticException("not divide by zero");
        }
        int quotient = 0;
        while (a >= b) {
            a = Minus(a, b);
            ++quotient;
        }
        return quotient;
    }


    /**
     * 判断是不是负数
     *
     * @param a
     * @return
     */
    public static boolean IsNegative(int a) {
        return (a & 0x8000) == 0 ? false : true;
    }


    /**
     * 判断是不是0
     *
     * @param a
     * @return
     */
    public static boolean IsZero(int a) {
        return (a & 0xFFFF) == 0;
    }

    /***
     *判断是否是正数
     * @param a
     * @return
     */
    public static boolean IsPositive(int a) {
        if ((a & 0x8000) == 0 && (a & 0xFFFF) != 0) {
            return true;
        }
        return false;
    }


    /**
     * 乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int Multi(int a, int b) {
        if (IsZero(a) || IsZero(b)) {
            return 0;
        }
        int ans = 0;
        if (IsNegative(a)) {
            if (IsNegative(b)) {
                ans = Multi_pos(negative(a), negative(b));
            } else {
                ans = negative(Multi_pos(negative(a), b));
            }
        } else {
            if (IsNegative(b)) {
                ans = negative(Multi_pos(a, negative(b)));
            } else {
                ans = Multi_pos(a, b);
            }
        }
        return ans;
    }


    public static int Divide(int a, int b) {
        if (IsZero(b)) {
            throw new ArithmeticException("NOT DIVIDE BY ZERO");
        }
        int ans = 0;
        if (IsNegative(a)) {
            if (IsNegative(b)) {
                ans = Divide_pos(negative(a), negative(b));
            } else {
                ans = negative(Divide_pos(negative(a), b));
            }
        } else {
            if (IsNegative(b)) {
                ans = negative(Divide_pos(a, negative(b)));
            } else {
                ans = Divide_pos(a, b);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Divide(-4,3));
    }

}
