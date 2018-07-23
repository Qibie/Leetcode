package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetteCombinationsofaPhoneNumbe {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        StringBuilder sb = new StringBuilder();
        Map<Character, String> digitToString = mapDigittoString();
        helper(digits, sb, digitToString, result, 0);
        return result;
    }

    public void helper(String digits, StringBuilder sb, Map<Character, String> digitToString, List<String> result, int pos) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        if (pos >= digits.length())
            return;
        String str = digitToString.get(digits.charAt(pos));
        for (int i = 0; i < str.length(); ++i) {
            sb.append(str.charAt(i));
            helper(digits, sb, digitToString, result, pos + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public Map<Character, String> mapDigittoString() {
        Map<Character, String> digitToString = new HashMap<>();
        digitToString.put('2', "abc");
        digitToString.put('3', "def");
        digitToString.put('4', "ghi");
        digitToString.put('5', "jkl");
        digitToString.put('6', "mno");
        digitToString.put('7', "pqrs");
        digitToString.put('8', "tuv");
        digitToString.put('9', "wxyz");
        return digitToString;
    }


    public static void main(String[] args) {
        System.out.println(new LetteCombinationsofaPhoneNumbe().letterCombinations("23"));
    }

}
