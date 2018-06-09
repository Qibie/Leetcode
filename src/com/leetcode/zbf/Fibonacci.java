package com.leetcode.zbf;

public class Fibonacci {
    public int fibonacciRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public int fibonacciIterable(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1, second = 1, current = 0;
        for (int i = 3; i <= n; ++i) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }


    public int[] fibonacciFomat(int n) {
        if (n == 1) {
            return new int[]{1, 1, 1, 0};
        }
        if (n == 2) {
            return new int[]{2, 1, 1, 1};
        }
        int[] a = new int[4];
        int subn = n % 2 == 0 ? (n / 2) : ((n - 1) / 2);
        int[] suba = fibonacciFomat(subn);
        a[0] = suba[0] * suba[0] + suba[1] * suba[2];
        a[1] = suba[0] * suba[1] + suba[1] * suba[3];
        a[2] = suba[2] * suba[0] + suba[3] * suba[2];
        a[3] = suba[2] * suba[1] + suba[3] * suba[3];
        if (n % 2 == 0) {
            return a;
        } else {
            int[] return_a = new int[4];
            return_a[0]=a[0]+a[1];
            return_a[1]=a[0];
            return_a[2]=a[2]+a[3];
            return_a[3]=a[2];
            return return_a;
        }
    }


    public int fibonacci(int n){
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciFomat(n-1)[0];
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(5));
    }
}
