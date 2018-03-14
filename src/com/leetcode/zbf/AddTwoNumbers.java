package com.leetcode.zbf;

/**
 * Created by curry on 17-12-8.
 */


///**
// * Definition for singly-linked list.
// */
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1, q = l2, currentNode = dummyNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null ? p.val : 0);
            int y = (q != null ? q.val : 0);
            int sum = x + y + carry;
            currentNode.next = new ListNode(sum % 10);
            carry = sum % 10;
            currentNode = currentNode.next;
            if (p != null) {
                p = p.next;
            }
            if(q!=null){
                q=q.next;
            }
        }
        if(carry>0){
            currentNode.next=new ListNode(carry);
        }
        return dummyNode.next;

    }


    //    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long lResult1=getnum(l1),lResult2=getnum(l2);
//        char[] result=String.valueOf(lResult1+lResult2).toCharArray();
//        ListNode resultNode=new ListNode(result[result.length-1]-'0');
//        ListNode tempNode=resultNode;
//        for(int i=result.length-2;i>=0;i--){
//            tempNode.next=new ListNode(result[i]-'0');
//            tempNode=tempNode.next;
//        }
//        tempNode.next=null;
//        return resultNode;
//
//    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode resultNode, tempNode, leftNode = l1, rightNode = l2;
//        int value = leftNode.val + rightNode.val;
//        if (value < 10) {
//            resultNode = new ListNode(value);
//        } else {
//            resultNode = new ListNode(value - 10);
//            resultNode.next = new ListNode(1);
//        }
//
//        //合并
//        while(leftNode.next!=null|| rightNode.next!=null){
//            if(leftNode.next==null){
//                leftNode.next=new ListNode(0);
//            }
//            if(rightNode.next==null){
//                rightNode.next=new ListNode(0);
//            }
//            leftNode = leftNode.next;
//            rightNode = rightNode.next;
//        }
//        leftNode = l1.next;
//        rightNode = l2.next;
//        tempNode = resultNode;
//
//        while (leftNode != null && rightNode != null) {
//            tempNode.next=addTwoNode(tempNode.next,leftNode,rightNode);
//            leftNode=leftNode.next;
//            rightNode=rightNode.next;
//            tempNode=tempNode.next;
//        }
//
//        return resultNode;
//    }
//
//    public ListNode addTwoNode(ListNode tempNode,ListNode l1, ListNode l2) {
//        int value = l1.val + l2.val;
//        ListNode node;
//        if (value < 10) {
//            node=new ListNode(value);
//            if(tempNode!=null){
//                int value1=node.val+tempNode.val;
//                if(value1<10){
//                    node.val=value1;
//                }else {
//                    node.val=value1-10;
//                    node.next=new ListNode(1);
//                }
//            }
//        }else {
//            node=new ListNode(value-10);
//            node.next=new ListNode(1);
//            if(tempNode!=null){
//                node.val=node.val+tempNode.val;
//            }
//        }
//        return node;
//    }


//    public long getnum(ListNode l) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.addFirst(l.val);
//        ListNode listNode = l;
//        while (listNode.next != null) {
//            linkedList.addFirst(listNode.next.val);
//            listNode = listNode.next;
//        }
//        long result = 0;
//        for (int i = 0; i < linkedList.size(); ++i) {
//            result = result * 10 + linkedList.get(i);
//        }
//        return result;
//    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = null;

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);
        listNode2.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        listNode2.next.next.next.next.next.next.next.next.next.next = null;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        int e = 3;
    }

}
