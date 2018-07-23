package com.leetcode.zbf;

public class WildcardMatchingII {
//    public static boolean isMatch(String s, String p) {
////        if (s == null || p == null)
////            return false;
////        if (s.equals("") && p.equals(""))
////            return true;
////        return ismatch(s, p);
////    }
////
////    public static boolean ismatch(String s, String p) {
////        if (s.equals("") && p.equals(""))
////            return true;
////        if (s.equals("")) {
////            for (int i = 0; i < p.length(); ++i)
////                if (p.charAt(i) != '*')
////                    return false;
////            return true;
////        }
////        if(p.equals(""))
////            return false;
////        else if (p.charAt(0) == '*')
////            return ismatch(s, p.substring(1)) || ismatch(s.substring(1), p.substring(1)) || ismatch(s.substring(1), p);
////        else if (p.charAt(0) == '?')
////            return ismatch(s.substring(1), p.substring(1));
////        else if (s.charAt(0) == p.charAt(0))
////            return ismatch(s.substring(1), p.substring(1));
////        return false;
////
////    }


    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] schars = s.toCharArray(), pchars = p.toCharArray();
        int sIndex = 0, pIndesx = 0, pp = -1, ss = -1;
        while (sIndex < schars.length) {
            if (pIndesx == pchars.length) {
                if (pp == -1)
                    return false;
                pIndesx = pp + 1;
                sIndex = ss++;
            } else if (pchars[pIndesx] == '?' || pchars[pIndesx] == schars[sIndex]) {
                ++pIndesx;
                ++sIndex;
            } else if (pchars[pIndesx] == '*') {
                pp = pIndesx;
                ss = sIndex;
                ++pIndesx;
            } else {
                if (pp == -1)
                    return false;
                pIndesx = pp + 1;
                sIndex = ss++;
            }
        }
        while (pIndesx < pchars.length) {
            if (pchars[pIndesx] != '*')
                return false;
            ++pIndesx;
        }
        return pIndesx == pchars.length;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("abc", "*d"));


    }

}
