package com.leetcode.zbf;

import com.sun.org.apache.regexp.internal.RE;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int pre_index = str.length();
        for (int i = str.length() - 1; i >= 0; --i) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append(str.substring(i + 1, pre_index)).append(" ");
                pre_index = i;
            }
        }
        stringBuilder.append(str.substring(0, pre_index));
        return stringBuilder.toString();

    }
}
