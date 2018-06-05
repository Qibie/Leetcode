package com.leetcode.zbf;

import java.util.concurrent.FutureTask;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s==null || p== null){
            return false;
        }
        if(s.isEmpty()|| p.isEmpty() ){
            if(s.isEmpty() && p.isEmpty()){
                return true;
            }else {
                return false;
            }
        }
//        StringBuilder sb=new StringBuilder(s).reverse();
//        StringBuilder pb=new StringBuilder(p).reverse();
        return false;
    }

    public static void main(String[] args) {

        System.out.println("1".equals(1));

    }
}
