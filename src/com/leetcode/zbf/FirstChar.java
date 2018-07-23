package com.leetcode.zbf;

import java.util.LinkedList;

public class FirstChar {
    private LinkedList<Character> linkedList = new LinkedList<>();
    private int[] hashtable = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {
        ++hashtable[ch];
        if (hashtable[ch] == 1) {
            linkedList.addLast(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while ((!linkedList.isEmpty()) && hashtable[linkedList.getFirst()] > 1)
            linkedList.removeFirst();
        if (linkedList.isEmpty())
            return '#';
        return linkedList.getFirst();
    }
}
