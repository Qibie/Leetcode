package com.leetcode.zbf;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    int minValue = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node < minValue) {
            minValue = node;
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int topValue = stack.pop();
            if (topValue == minValue) {
                find_min();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public void find_min() {
        minValue = Integer.MAX_VALUE;
        if (!stack.isEmpty()) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                int x = stack.pop();
                if (x < minValue) {
                    minValue = x;
                }
                temp.push(x);
            }
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }


    public int min() {
        return minValue;
    }
}
