package com.leetcode.zbf;

/**
 * Created by curry on 18-3-12.
 */


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.*;

public class CombinationSum {
   public List<List<Integer>> combinationSum(int []cadidates,int target){
       if(cadidates==null || cadidates.length<=0){
           return null;
       }
       List<List<Integer>> result=new ArrayList<>();
       List<Integer> temp=new ArrayList<>();
       dfs(result,temp,cadidates,target,0);
       return result;
   }
    public static void dfs(List<List<Integer>>result,List<Integer> temp,int [] cadidates,int target,int j){
       if(target==0){
           result.add(new ArrayList<>(temp));
           return;
       }
       for(int i=j;i<cadidates.length && target<=cadidates[i];i++){

           temp.add(cadidates[i]);
           dfs(result,temp,cadidates,target-cadidates[i],i);
           temp.remove(temp.size()-1);
       }
    }

    public static void main(String[] args) {
       List<Integer> temp=new ArrayList<>(Arrays.asList(1,2,3));
       List<List<Integer>> result=new ArrayList<>();
       result.add(new ArrayList<>(temp));
       System.out.println(result.get(0));
       temp.add(2,4);
       System.out.println(result.get(0));
    }

}


