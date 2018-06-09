package com.leetcode.zbf;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode priorNode=null,currentNode=head,futureNode=head.next;
        while (futureNode!=null){
            priorNode=currentNode;
            currentNode=futureNode;
            futureNode=futureNode.next;
            currentNode.next=priorNode;
        }
        currentNode.next=priorNode;
        head.next=null;
        return currentNode;
    }
}
