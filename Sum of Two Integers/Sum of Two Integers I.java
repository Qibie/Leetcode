import java.math.BigDecimal;
/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example: Given a = 1 and b = 2, return 3.
 * @author qibie-pc
 * @date 2018-04-28
 */
 
class Solution {
    public int getSum(int a, int b) {
        BigDecimal a1 = new BigDecimal(a); 
        BigDecimal b1 = new BigDecimal(b);
        BigDecimal result = a1.add(b1);
        return result.intValue();
    }
}