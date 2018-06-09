package com.leetcode.zbf;

public class MergeNode {
    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode result = null, priorNode = null;
        if (listNode1.val < listNode2.val) {
            result = listNode1;
            priorNode = listNode1;
            listNode1 = listNode1.next;
        } else {
            result = listNode2;
            priorNode = listNode2;
            listNode2 = listNode2.next;
        }


        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                priorNode.next = listNode1;
                priorNode=priorNode.next;
                listNode1 = listNode1.next;
            } else {
                priorNode.next = listNode2;
                priorNode=priorNode.next;
                listNode2 = listNode2.next;
            }
        }

        while (listNode1 != null) {
            priorNode.next = listNode1;
            priorNode=priorNode.next;
            listNode1 = listNode1.next;
        }
        while (listNode2 != null) {
            priorNode.next = listNode2;
            priorNode=priorNode.next;
            listNode2 = listNode2.next;
        }

        return result;


    }
}
