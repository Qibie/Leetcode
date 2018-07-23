package com.leetcode.zbf;

public class ReturnTest {

    public static void main(String[] args) {
        System.out.println(returnTest()[0]);
    }

    public static int[] returnTest() {
       int []a=new int[1];
       a[0]=0;
        try {
            a[0] = 1;
            return a;
        } catch (Exception e) {
            a[0] = 2;
            return a;
        } finally {
            a[0] = 3;
        }
    }

}

