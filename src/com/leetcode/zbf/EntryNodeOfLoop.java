package com.leetcode.zbf;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new LinkedHashSet<>();
        ListNode temp = pHead;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }


    public ListNode EntryNodeOfLoopNotSte(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode n1 = pHead.next, n2 = pHead.next.next;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = pHead.next;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
