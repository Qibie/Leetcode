package com.leetcode.zbf;

/**
 * Created by curry on 18-1-19.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head, temp;
        if (l1.val < l2.val) {
            temp = l1;
            head = l1;
            l1 = l1.next;
        } else {
            temp = l2;
            head = l2;
            l2 = l2.next;

        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp=temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp=temp.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            temp.next = l1;
            temp=temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.next=l2;
            temp=temp.next;
            l2 = l2.next;
        }
        return head;
    }
}
