package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null || candidates.length<=0){
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        dfs(result,temp,candidates,target,0);
        return result;
    }
    public static void dfs(List<List<Integer>> result,List<Integer> temp,int [] cadidates,int target,int j){
        if (target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=j;i<cadidates.length && cadidates[i]<=target;++i){
            if (i>j && cadidates[i]==cadidates[i-1]){
                continue;
            }
            temp.add(cadidates[i]);
            dfs(result,temp,cadidates,target-cadidates[i],i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] cadidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> result=combinationSum2(cadidates,target);
        for (List<Integer> list:result){
            System.out.println(list.toString());
        }

    }
}
