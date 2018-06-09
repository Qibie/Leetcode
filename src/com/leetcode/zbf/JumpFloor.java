package com.leetcode.zbf;

public class JumpFloor {
    public int jumpFloor(int target){
        int num=0;
        if(target==0){
            return 1;
        }
        if(target==1) {
            return jumpFloor(target-1);
        }else {
            for(int i=target-1;i>=0;--i){
                num +=jumpFloor(i);
            }
        }
        return num;
    }


    public int jumpFloorIterable(int target){
        int first=0,second=1,current=0;
        for(int i=1;i<=target;++i){
            current=first+second;
            first=second;
            second=current;
        }
        return current;
    }

    public int JumpFloorII(int target){
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int [] array=new int[target+1];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        for(int i=3;i<=target;++i){
            for(int j=i-1;j>=0;--j){
                array[i]+=array[j];
            }
            array[i]=array[i]+1;
        }
        return array[target];
    }


    public static void main(String[] args) {
        System.out.println(new JumpFloor().JumpFloorII(3));
    }

}
