package com.leetcode.zbf;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        if (sequence.length <= 1) {
            return true;
        }
        return verifySqence(sequence, 0, sequence.length - 1);
    }

    public boolean verifySqence(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int mid_index = start;
        for (; mid_index < end; ++mid_index) {
            if (sequence[mid_index] > sequence[end]) {
                break;
            }
        }
        for (int i = mid_index; i < end; ++i) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        boolean left_verify = verifySqence(sequence, start, mid_index - 1), right_verify = verifySqence(sequence, mid_index, end - 1);
        return (left_verify && right_verify);
    }

}
