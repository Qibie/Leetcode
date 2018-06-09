package com.leetcode.zbf;

import org.omg.CORBA.BAD_CONTEXT;

public class MathPower {
    public double Power(double base, int exponent) {
        if(equal(base,0.0) && exponent<0){
            return -1;
        }
        if(exponent==0){
            return  1;
        }
        boolean flag=exponent<0?true:false;
        exponent=exponent<0?-exponent:exponent;
        double result=PowerImplement(base,exponent);
        if(flag){
            return 1.0/result;
        }else {
            return result;
        }
    }


    /**
     * 用 >>1 代替除以2
     * 用 & 1 ==1 代替判断吗是否奇偶数
     * @param base
     * @param exponent
     * @return
     */

    public double PowerImplement(double base ,int exponent){
        if(exponent ==1){
            return base;
        }
        double result=PowerImplement(base,exponent>>1);
        result=result*result;
        if((exponent & 0x1) ==1){
            result*=base;
        }
        return result;
    }


    public boolean equal(double number1, double number2) {
        if (Math.abs(number1 - number2) < 0.0000001 ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new MathPower().Power(2,-3));
    }
}
