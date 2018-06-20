package com.leetcode.zbf;

import java.util.HashMap;
import java.util.Map;

public class RandomListClone {
    public RandomListNode Clone_map(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode cHead = new RandomListNode(pHead.label), p_temp = pHead.next, c_temp = cHead;
        nodeMap.put(pHead, cHead);
        while (p_temp != null) {
            c_temp.next = new RandomListNode(p_temp.label);
            c_temp = c_temp.next;
            nodeMap.put(p_temp, c_temp);
            p_temp = p_temp.next;
        }
        p_temp = pHead;
        c_temp = cHead;
        while (p_temp != null) {
            c_temp.random = nodeMap.get(p_temp.random);
            p_temp = p_temp.next;
            c_temp = c_temp.next;
        }
        return cHead;
    }


    public void copySequenceNode(RandomListNode pHead) {
        RandomListNode temp = pHead, cloneNode;
        while (temp != null) {
            cloneNode = new RandomListNode(temp.label);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }
    }

    public void copyRandomNode(RandomListNode pHead) {
        RandomListNode temp = pHead, cloneNode;
        while (temp != null) {
            cloneNode = temp.next;
            if (temp.random != null) {
                cloneNode.random = temp.random.next;
            }
            temp = cloneNode.next;
        }
    }

    public RandomListNode splitList(RandomListNode pHead) {
        RandomListNode cHead = pHead.next, c_temp = cHead;
        while (c_temp.next != null) {
            c_temp.next = c_temp.next.next;
            c_temp = c_temp.next;
        }
        return cHead;
    }


    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        copySequenceNode(pHead);
        copyRandomNode(pHead);
        return splitList(pHead);
    }

}
