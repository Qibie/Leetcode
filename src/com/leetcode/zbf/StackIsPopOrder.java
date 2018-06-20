package com.leetcode.zbf;

import java.util.Stack;

public class StackIsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null && popA == null) {
            return true;
        }
        if (pushA.length == 0 && popA.length == 0) {
            return true;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int k = 1;
        for (int i = 0; i < popA.length; ++i) {
            int a = stack.peek();
            if (a == popA[i]) {
                stack.pop();
            } else {
                int temp = k;
                for (; temp < pushA.length; ++temp) {
                    if (pushA[temp] ==  popA[i]) {
                        for (int j = k; j <= temp; ++j) {
                            stack.push(pushA[j]);
                        }
                        stack.pop();
                        k = temp + 1;
                        break;
                    }
                }
                if (temp >= pushA.length) {
                    return false;
                }
            }
        }
        return true;
    }
}
