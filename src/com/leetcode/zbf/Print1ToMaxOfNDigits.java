package com.leetcode.zbf;

public class Print1ToMaxOfNDigits {
//    public void print1ToMaxNDights(int n) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < n; ++i) {
//            stringBuilder.append('0');
//        }
//        while (!Increment(stringBuilder)) {
//            printStringNumber(stringBuilder);
//        }
//    }
//
//    public boolean Increment(StringBuilder stringBuilder) {
//        boolean isMaxed = false;
//        int numIncrement = 1, n = stringBuilder.length();
//        for (int i = n - 1; i >= 0; --i) {
//            int num = stringBuilder.charAt(i) - '0' + numIncrement;
//            if (num >= 10) {
//                if (i == 0) {
//                    isMaxed = true;
//                } else {
//                    num -= 10;
//                    stringBuilder.setCharAt(i, (char) ('0' + num));
//                }
//            } else {
//                stringBuilder.setCharAt(i, (char) ('0' + num));
//                break;
//            }
//        }
//        return isMaxed;
//    }
//
    public void printStringNumber(StringBuilder stringBuilder) {
        int n = stringBuilder.length();
        int i;
        for (i = 0; i < n; ++i) {
            if(stringBuilder.charAt(i)>'0'){
                break;
            }
        }
        System.out.println(stringBuilder.subSequence(i,n).toString());
    }



    public void print1ToMaxNDights(int n){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<n;++i){
            stringBuilder.append('0');
        }
        for(int i=0;i<=9;++i){
            stringBuilder.setCharAt(0,(char)(i+'0'));
            print1ToMaxNDigitsRecursion(stringBuilder,n,0);
        }

    }

    public void print1ToMaxNDigitsRecursion(StringBuilder stringBuilder,int n,int index){
        if(index== n-1){
            printStringNumber(stringBuilder);
        }else {
            for(int i=0;i<=9;++i){
                stringBuilder.setCharAt(index+1,(char)(i+'0'));
                print1ToMaxNDigitsRecursion(stringBuilder,n,index+1);
            }
        }

    }



    public static void main(String[] args) {
        new Print1ToMaxOfNDigits().print1ToMaxNDights(3);
    }

}
