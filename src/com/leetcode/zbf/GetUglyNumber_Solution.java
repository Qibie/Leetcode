package com.leetcode.zbf;

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int index2 = 1, index3 = 1, index5 = 1, temp_index = 1, next_ugly = 0;
        int[] uglyNumber = new int[index + 1];
        uglyNumber[1] = 1;
        for (int i = 2; i <= index; ++i) {
            next_ugly = (uglyNumber[index2] * 2 < uglyNumber[index3] * 3) ? uglyNumber[index2] * 2 : uglyNumber[index3] * 3;
            next_ugly = (uglyNumber[index5] * 5 < next_ugly) ? uglyNumber[index5] * 5:next_ugly;
            uglyNumber[i] = next_ugly;
            if (next_ugly / 2 == uglyNumber[index2])
                ++index2;
            if (next_ugly / 3 == uglyNumber[index3])
                ++index3;
            if (next_ugly / 5 == uglyNumber[index5])
                ++index5;
        }
        return uglyNumber[index];
    }


    public static void main(String[] args) {
        System.out.println(new GetUglyNumber_Solution().GetUglyNumber_Solution(3));
    }
}
