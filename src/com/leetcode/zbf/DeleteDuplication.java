package com.leetcode.zbf;

public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }

        ListNode preDuplicated = new ListNode(Integer.MAX_VALUE), firstDuplicated = pHead, currNode = pHead.next;
        preDuplicated.next = pHead;
        pHead = preDuplicated;
        while (currNode != null) {
            if (currNode.val == firstDuplicated.val) {
                while (currNode != null && currNode.val == firstDuplicated.val) {
                    currNode = currNode.next;
                }
                preDuplicated.next = currNode;
                firstDuplicated = currNode;
                currNode = currNode == null ? null : currNode.next;
                continue;
            }
            preDuplicated = firstDuplicated;
            firstDuplicated = currNode;
            currNode = currNode.next;
        }
        if (pHead.next == null) {
            return new ListNode(0);
        }
        return pHead.next;
    }
}
