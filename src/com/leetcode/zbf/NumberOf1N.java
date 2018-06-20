package com.leetcode.zbf;

public class NumberOf1N {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        String str = n + "";
        return numberOf1(str);
    }

    public int numberOf1(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1 && str.charAt(0) == '0') {
            return 0;
        }
        if (str.length() == 1 && str.charAt(0) == '1') {
            return 1;
        }
        int numFirstDigit = 0, numOtherDigits = 0;
        if (str.charAt(0) > '1') {
            numFirstDigit = (int) Math.pow(10, str.length() - 1);
        } else if(str.charAt(0)=='1'){
            numFirstDigit = Integer.parseInt(str.substring(1)) + 1;
        }
        numOtherDigits = (str.charAt(0) - '0') * (int) Math.pow(10, str.length() - 2) * (str.length() - 1);
        return numFirstDigit + numOtherDigits + numberOf1(str.substring(1));
    }


    public static void main(String[] args) {
        System.out.println(new NumberOf1N().NumberOf1Between1AndN_Solution(10000));
    }
}
