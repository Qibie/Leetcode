package com.leetcode.zbf;

import java.util.ArrayList;

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null ){
            return new ArrayList<>();
        }
        ArrayList<Integer> resultList=new ArrayList<>();
        if(listNode.next!=null){
            resultList.addAll(printListFromTailToHead(listNode.next));
        }
        resultList.add(listNode.val);
        return resultList;
    }
}
