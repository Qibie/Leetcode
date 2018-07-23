package com.backtracking;


import java.util.ArrayList;
import java.util.List;

public class OfferHasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || rows <= 0 || cols <= 0 || str == null || str.length == 0)
            return false;
        List<List<Integer>> currPath = new ArrayList<>();
        boolean flag = false;
        for (int x=0; x < rows; ++x) {
            for (int y=0; y < cols; ++y) {
                if (matrix[y + x * cols] == str[0]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y);
                    currPath.add(temp);
                    flag = flag || helper(matrix, currPath, rows, cols, str);
                    currPath.remove(currPath.size() - 1);
                }
            }
        }
        return flag;
    }

    public boolean helper(char[] matrix, List<List<Integer>> currPath, int rows, int cols, char[] str) {
        int currSize = currPath.size();
        if (currSize == str.length)
            return true;
        if (currSize == 0)
            return false;
        boolean flag = false;
        int preX = currPath.get(currSize - 1).get(0), preY = currPath.get(currSize - 1).get(1);
        if (preX > 0 && matrix[preY + (preX - 1) * cols] == str[currSize]) {
            if (check(currPath, preX - 1, preY)) {
                List<Integer> indexs = new ArrayList<>();
                indexs.add(preX - 1);
                indexs.add(preY);
                currPath.add(indexs);
                flag = flag || helper(matrix, currPath, rows, cols, str);
                currPath.remove(currSize);
            }
        }
        if (preX < rows - 1 && matrix[preY + (preX + 1) * cols] == str[currSize]) {
            if (check(currPath, preX + 1, preY)) {
                List<Integer> integers = new ArrayList<>();
                integers.add(preX + 1);
                integers.add(preY);
                currPath.add(integers);
                flag = flag || helper(matrix, currPath, rows, cols, str);
                currPath.remove(currSize);
            }
        }
        if (preY > 0 && matrix[preY - 1 + preX * cols] == str[currSize]) {
            if (check(currPath, preX, preY - 1)) {
                List<Integer> integers = new ArrayList<>();
                integers.add(preX);
                integers.add(preY - 1);
                currPath.add(integers);
                flag = flag || helper(matrix, currPath, rows, cols, str);
                currPath.remove(currSize);
            }
        }
        if (preY < cols - 1 && matrix[preY + 1 + preX * cols] == str[currSize]) {
            if (check(currPath, preX, preY + 1)) {
                List<Integer> integers = new ArrayList<>();
                integers.add(preX);
                integers.add(preY + 1);
                currPath.add(integers);
                flag = flag || helper(matrix, currPath, rows, cols, str);
                currPath.remove(currSize);
            }
        }
        return flag;
    }

    public boolean check(List<List<Integer>> currPath, int x, int y) {
        for (List<Integer> list : currPath) {
            if (list.get(0) == x && list.get(1) == y)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "ABCESFCSADEE", str = "SEE";
        System.out.println(new OfferHasPath().hasPath(s.toCharArray(), 3, 4, str.toCharArray()));

    }


}
