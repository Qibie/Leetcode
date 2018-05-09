package com.leetcode.zbf;

public class TrappingRainWater {
//    public static int trap(int[] height) {
//        if(height==null || height.length==0){
//            return 0;
//        }
//        int  sum=0,n=height.length,min=0;
//        boolean flag=false;
//        while (flag==false){
//            int i=0,j=n-1;
//            for(i=0;i<n;++i){
//                if(height[i]>0){
//                    break;
//                }
//            }
//            for(j=n-1;j>i;--j){
//                if(height[j]>0){
//                    break;
//                }
//            }
//            if(j<=i){
//                break;
//            }
//            min=height[i]<height[j]?height[i]:height[j];
//            sum+=(j-i-1)*min;
//            for(int k=i+1;k<j;++k){
//                if(height[k]>0){
//                    if(height[k]<min){
//                        sum-=height[k];
//                    }else {
//                        sum-=min;
//                    }
//                }
//            }
//            flag=true;
//            for(int k=i;k<=j;++k){
//                if(height[k]>0){
//                    flag=false;
//                   if(height[k]<min){
//                       height[k]=0;
//                   }else {
//                       height[k]-=min;
//                   }
//                }
//            }
//        }
//        return sum;
//    }

    public static int trap(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        int sum=0,left=0,right=height.length-1;
        int max_left=height[left],max_rigth=height[right];
        while (left<right){
            if(max_left<=max_rigth){
                while (left<right && height[left]<=max_left){
                    sum+=(max_left-height[left]);
                    ++left;
                }
                if(left>=right){
                    break;
                }else {
                    max_left=height[left];
                }
            }else {
                while (right>left && height[right]<=max_rigth){
                    sum+=(max_rigth-height[right]);
                    --right;
                }
                if(right<=left){
                    break;
                }else {
                    max_rigth=height[right];
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int [] height={4,2,3};
        System.out.println(trap(height));
    }
}
