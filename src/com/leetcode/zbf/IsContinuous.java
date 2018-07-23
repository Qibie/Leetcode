package com.leetcode.zbf;

import java.util.Arrays;

public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        if (numbers.length == 1) {
            return true;
        }
        Arrays.sort(numbers);
        int numOfZero = 0, numOfInterval = 0, length = numbers.length;
        for (int i = 0; i < length - 1; ++i) {
            if (numbers[i] == 0) {
                ++numOfZero;
                continue;
            }
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            numOfInterval += (numbers[i + 1] - numbers[i] - 1);
        }
        if (numOfInterval <= numOfZero) {
            return true;
        }
        return false;
    }
}
