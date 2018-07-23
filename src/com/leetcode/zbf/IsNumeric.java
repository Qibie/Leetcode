package com.leetcode.zbf;

public class IsNumeric {

    /**
     * 科学记数法的条件
     * a*e|E b ，其中：a是绝对值小于10大于1的数
     * 先判断有没有E或者e
     * 有:前后判断，前面是是绝对值小于10大于1的数，可以是小数  后面不能是小数
     * 没有，正常判断
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int length = str.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(str[i]);
        }
        //判断是不是科学计数法
        if (sb.lastIndexOf("e") != -1 || sb.lastIndexOf("E") != -1) {
            //表示是科学记数發，先判斷後面的是不是合格
            int index = sb.lastIndexOf("e") != -1 ? sb.lastIndexOf("e") : sb.lastIndexOf("E");
            //e后面没有字符，直接返回false
            if (index == length - 1) {
                return false;
            }
            String afterE = sb.substring(index + 1);
            if (afterE.contains(".")) {
                return false;
            }
            return isNumericNotWithE(sb.substring(0, index)) && isNumericNotWithE(afterE);
        }
        return isNumericNotWithE(sb.toString());
    }

    /**
     * 判斷是不是合格的數,不包含科学技术法
     *
     * @param s
     * @return
     */
    public boolean isNumericNotWithE(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //只有一个字符，并且不是数字
        if (s.length() == 1 && (s.charAt(0) > '9' || s.charAt(0) < '0')) {
            return false;
        }
        //开头违法字符
        if (s.charAt(0) > '9' || s.charAt(0) < '0') {
            if (s.charAt(0) != '+' && s.charAt(0) != '-') {
                return false;
            }
        }
        //中间违法字符
        int numofpoint = 0;
        for (int i = 1; i < s.length(); ++i) {
            if ((s.charAt(i) > '9' || s.charAt(i) < '0')) {
                if (s.charAt(i) != '.')
                    return false;
                numofpoint = s.charAt(i) == '.' ? ++numofpoint : numofpoint;
                if ((s.charAt(i) == '.' && numofpoint > 1)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean matchRegex(char[] chars) {
        if (chars == null || chars.length == 0) {
            return false;
        }
        String str = String.valueOf(chars);
        return str.matches("[\\+\\-]?\\d+(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }


    public static void main(String[] args) {
        System.out.println(new IsNumeric().isNumeric("123.45e+6".toCharArray()));
    }


}
