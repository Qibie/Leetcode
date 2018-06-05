package com.leetcode.zbf;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class FindJob {
    public Map<Integer,Integer> map=new HashMap<>();
    public int [] Di;
    public int [] Ai;
    public int N,M;
    public FindJob(int N,int M){
        this.N=N;
        this.M=M;
        Di=new int[N];
        Ai=new int[M];
    }
    public int []  findjob(){
        int [] result=new  int[M];
        Arrays.sort(Di);
        for (int i=0;i<M;++i){
            int k = findDi(Ai[i]);
            if(k<0){
                result[i]=0;
            }else if (Di[k] == Ai[i]) {
                result[i] = map.get(Di[k]);
            } else if (k>0){
                result[i] = map.get(Di[k - 1]);
            }else {
                result[i]=0;
            }
        }

        return result;
    }
    public int findDi(int ai){
        int low=0,hign=N-1,mid;
        while (low<hign){
            mid=(low+hign)/2;
            if(Di[mid]==ai){
                return mid;
            }else if(Di[mid]>ai){
                hign=mid -1;
            }else{
                low=mid+1;
            }
        }
        return hign;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String [] numstr=str.split(" ");

        try {
            int n=Integer.parseInt(numstr[0]);
            int m= Integer.parseInt(numstr[1]);
            FindJob findJob=new FindJob(n,m);
            for (int i=0;i<n;++i){
                str=scanner.nextLine();
                numstr=str.split(" ");
                int d=Integer.parseInt(numstr[0]),k=Integer.parseInt(numstr[1]);
                findJob.Di[i]=d;
                findJob.map.put(d,k);
            }
            str=scanner.nextLine();
            numstr=str.split(" ");
            for (int i=0;i<m;++i){
                findJob.Ai[i]=Integer.parseInt(numstr[i]);
            }
           int [] result=findJob.findjob();
            for(int i=0;i<result.length;++i){
                System.out.println(result[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.printf("baibai");
        }
    }

}
