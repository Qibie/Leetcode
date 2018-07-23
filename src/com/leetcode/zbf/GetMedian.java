package com.leetcode.zbf;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    int count = 1;

    public void Insert(Integer num) {
        int temp = 0;
        if ((count & 1) == 0) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        ++count;
    }

    public Double GetMedian() {
        if (minHeap.size() == maxHeap.size())
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        else
            return (double) minHeap.peek();
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
        GetMedian getMedian = new GetMedian();
        for (int i : array) {
            getMedian.Insert(i);
            System.out.println(getMedian.GetMedian());
        }
    }

}
