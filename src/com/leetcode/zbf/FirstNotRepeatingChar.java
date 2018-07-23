package com.leetcode.zbf;


public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] hashtable = new int[58];
        for (int i = 0; i < str.length(); ++i) {
            ++hashtable[str.charAt(i) - 'A'];
        }
        for (int i = 0; i < str.length(); ++i) {
            if (hashtable[str.charAt(i) - 'A'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println('A' - 'a');
    }
}
