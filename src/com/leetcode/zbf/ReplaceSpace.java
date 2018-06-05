package com.leetcode.zbf;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if(str==null || str.length()==0){
            return "";
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<str.length();++i){
            if(str.charAt(i)==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
