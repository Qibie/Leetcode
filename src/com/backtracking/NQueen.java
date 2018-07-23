package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
//        if (n <= 2)
//            return result;
        List<String> currPos = new ArrayList<>();
        helper(n, currPos, result);
        return result;
    }

    public void helper(int n, List<String> currPos, List<List<String>> result) {
        int pos = currPos.size();
        if (pos == n) {
            result.add(new ArrayList<>(currPos));
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!check(currPos, pos, i))
                continue;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i; ++j)
                stringBuilder.append(".");
            stringBuilder.append("Q");
            for (int j = i + 1; j < n; ++j)
                stringBuilder.append(".");
            currPos.add(stringBuilder.toString());
            helper(n, currPos, result);
            currPos.remove(currPos.size() - 1);
        }

    }

    public List<List<String>> solveNQueens_itearble(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n==1){
            result.add(new ArrayList<String>(){{add("Q");}});
            return result;
        }
        int[] queen = new int[n];
        int k = 0, i = 0;
        for(int j=0;j<n;++j)
            queen[j]=-1;
        while (k < n) {
            while (i < n) {
                if (!check(queen, k, i)) {
                    ++i;
                    continue;
                }
                queen[k]=i;
                i=0;
                break;
            }
            if(queen[k]==-1){
                if(k==0)
                    break;
                --k;
                i=queen[k]+1;
                queen[k]=-1;
            }else {
                if(k==n-1){
                    result.add(getResult(n,queen));
                    queen[k]=-1;
                    --k;
                    i=queen[k]+1;
                    queen[k]=-1;
                    continue;
                }
                ++k;
            }
        }
        return result;
    }


    public boolean check(int[] queen, int row, int col) {
        for(int i=0;i<row;++i)
            if(queen[i]==col)
                return false;
        for(int i=0;i<row;++i)
            if((row-i)==Math.abs(col-queen[i]))
                return false;
        return true;
    }


    public List<String> getResult(int n, int[] queen) {
        List<String> result = new ArrayList<>();
        for (int q : queen) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < q; ++i)
                sb.append(".");
            sb.append("Q");
            for (int i = q + 1; i < n; ++i)
                sb.append(".");
            result.add(sb.toString());
        }
        return result;
    }


    public boolean check(List<String> currPos, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (currPos.get(i).indexOf("Q") == col)
                return false;
        }

        for (int i = 0; i < row; ++i) {
            int index = currPos.get(i).indexOf("Q");
            if (row - i == Math.abs(col - index))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new NQueen().solveNQueens_itearble(2));
    }


}
