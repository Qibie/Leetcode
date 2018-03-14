package com.leetcode.zbf;

/**
 * Created by curry on 18-3-12.
 */
public class CountandSay {
    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String result = "1";
        for (int k = 1; k < n; ++k) {
            StringBuilder temp_result = new StringBuilder();
            int i = 0;
            while (i < result.length()) {
                int num = 1;
                while (i < (result.length() - 1) && result.charAt(i) == result.charAt(i + 1)) {
                    ++num;
                    ++i;
                }
                temp_result.append(num).append(result.charAt(i));
                ++i;
            }
            result = temp_result.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(countAndSay(5));
    }
}
