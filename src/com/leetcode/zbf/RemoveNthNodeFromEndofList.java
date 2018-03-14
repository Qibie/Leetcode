package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by curry on 18-1-19.
 */
public class RemoveNthNodeFromEndofList {
    /**
     * Definition for singly-linked list.
     */


    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodeStack = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodeStack.add(node);
            node = node.next;
        }
        if(nodeStack.size()==n){
            return head.next;
        }
        node =nodeStack.get(nodeStack.size()-n-1);
        node.next=node.next.next;
        return head;
    }
}
