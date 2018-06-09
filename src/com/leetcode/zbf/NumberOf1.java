package com.leetcode.zbf;

import java.util.Map;

public class NumberOf1 {
    /**
     * error
     *
     * @param n
     * @return
     */
    public int NumberOf1_qiyong(int n) {
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) {
            throw new RuntimeException();
        }
        if (n == Integer.MIN_VALUE) {
            return 1;
        }
        int[] numbers = new int[2];
        int temp = Math.abs(n);
        while (temp / 2 != 0) {
            numbers[temp % 2]++;
            temp = temp / 2;
        }
        numbers[temp]++;
        if (n > 0) {
            return numbers[1];
        } else {
            return 32 - numbers[1];
        }
    }

    public int numberOf1(int n) {
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) {
            throw new RuntimeException("fuck input");
        }
        int count = 0,flag=1,i=0;
        while (i<32){
            if( (n & flag)==flag){
                ++count;
            }
            flag=flag<<1;
            ++i;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
    }

}
