package com.leetcode.zbf;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by curry on 17-12-9.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> characterSet =new HashSet<>();
        int maxSize=0;
        int index=0,currentLength=0;
        while(index<chars.length){
            characterSet.clear();
            currentLength=0;
            for(int i=index;i<chars.length;i++){
                char cs=chars[i];
                if(!characterSet.contains(cs)){
                    currentLength++;
                    characterSet.add(cs);
                }else{
                    break;
                }
            }
            maxSize=maxSize>currentLength?maxSize:currentLength;
            index++;
        }
        return maxSize;
    }

    public static void main(String []args){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
