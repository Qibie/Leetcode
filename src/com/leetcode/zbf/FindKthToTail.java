package com.leetcode.zbf;

import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

public class FindKthToTail {
    public ListNode findKthToTail(ListNode node, int k) {
        if(k<=0){
            return null;
        }
        ListNode first = node, second = node;
        int distancs = 0;
        while (first != null) {
            first = first.next;
            distancs++;
            if (distancs > k) {
                second = second.next;
            }
        }
        if(distancs<k){
            return null;
        }
        else {
            return second;
        }
    }
}
