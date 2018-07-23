package com.leetcode.zbf;

public class StringMatch {


    /**
     * 分两种情况
     * 1  模式第二个字符不是 *
     * 字符串第一个字符同模式第一个字符相匹配，字符串和模式的索引都加一，比较后面的
     * 字符串第一个字符同模式第一个字符不匹配，直接返回false
     * 2  模式第二个字符是 *
     * 字符串第一个字符同模式第一个字符不匹配，模式的索引加二，继续匹配
     * 字符串第一个字符同模式第一个字符匹配，模式的索引加2，字符串的索引加1，即*匹配一个
     * 字符第一个字符同模式第一个字符匹配，字符串的索引加1，模式索引不动，即* 匹配多个
     * 字符串第一個字符同模式第一個字符匹配，字符索引不動 模式索引加2，即* 匹配0個
     * <p>
     * <p>
     * 结束条件：
     * 第一种情况中，字符串不匹配，直接返回false
     * 当字符串索引和模式索引都达到最后的时候，返回true
     * 当字符串索引先打到最后的时候，返回false
     * 当模式索引先达到最后的时候，按照之前的算法，已经包含在里面了
     * 后面有*的时候，回反复调用，最后返回false
     * 没有*的时候，返回false
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.equals("") && pattern.equals(""))
            return true;

        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        int strLength = str.length, patternLength = pattern.length;
        if (strIndex == strLength && patternLength == patternIndex) {
            return true;
        }
        if (strIndex != strLength && patternIndex == patternLength) {
            return false;
        }
        //如果模式的第二个字符是 *
        if (patternIndex + 1 < patternLength && pattern[patternIndex + 1] == '*') {
            //如果模式的第一个字符和字符串的第一个字符相匹配
            if ((strIndex != strLength && str[strIndex] == pattern[patternIndex]) || (strIndex != strLength && pattern[patternIndex] == '.')) {
                return matchCore(str, strIndex + 1, pattern, patternIndex)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex, pattern, patternIndex + 2);
            } else {
                //模式的第一個字符同字符串的第一個字符不匹配
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if ((strIndex != strLength && str[strIndex] == pattern[patternIndex]) || (strIndex != strLength && pattern[patternIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
