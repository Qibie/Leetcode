package com.leetcode.zbf;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1==null || num2==null || num1.length()==0 || num2.length()==0){
            return "0";
        }
        StringBuilder stringBuilder1=new StringBuilder(num1).reverse();
        StringBuilder stringBuilder2=new StringBuilder(num2).reverse();
        int [] d=new int[stringBuilder1.length()+stringBuilder2.length()];
        for (int i=0;i<stringBuilder1.length();++i){
            for(int j=0;j<stringBuilder2.length();++j){
                d[i+j]+=(stringBuilder1.charAt(i)-'0')*(stringBuilder2.charAt(j)-'0');
            }
        }
        StringBuilder result=new StringBuilder();
        for (int i=0;i<d.length;++i){
            int units=d[i]%10;
            int tens=d[i]/10;
            if(i+1<d.length){
                d[i+1]+=tens;
            }
            result.insert(0,units);
        }
        while (result.charAt(0)=='0' && result.length()>1){
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String nums1="123",nums2="456";
        System.out.println(multiply(nums1,nums2));
    }
}
