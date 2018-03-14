package com.leetcode.zbf;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by curry on 18-1-19.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length()<=1 || s.length()%2==1){
            return false;
        }
        LinkedList<Character> stackList = new LinkedList<>();
        Map<Character, Character> validMap = new HashMap<>();
        validMap.put('(', ')');
        validMap.put(')', '(');
        validMap.put('[', ']');
        validMap.put(']', '[');
        validMap.put('{', '}');
        validMap.put('}', '{');
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i);
            if (stackList.size() == 0) {
                if (a == ')' || a == ']' || a == '}') {
                    return false;
                } else {
                    stackList.addLast(a);
                }
            } else {
                if (stackList.getLast().equals(validMap.get(a))) {
                    stackList.removeLast();
                } else {
                    if (a == ')' || a == ']' || a == '}') {
                        return false;
                    } else {
                        stackList.addLast(a);
                    }
                }
            }


        }
        if(stackList.size()==0){
            return true;
        }else {
            return false;
        }
    }
}
