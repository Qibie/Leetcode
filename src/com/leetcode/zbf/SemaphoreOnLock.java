package com.leetcode.zbf;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreOnLock {
    private final ReentrantLock lock=new ReentrantLock();
    private final Condition condition=lock.newCondition();
    private int permits;

    public SemaphoreOnLock(int permits){
        lock.lock();
        try {
            permits=permits;
        }finally {
            lock.unlock();
        }
    }

    public void accure() throws InterruptedException{
        lock.lock();
        try {
            while (permits<=0){
                condition.await();
            }
            --permits;
        }finally {
            lock.unlock();
        }
    }

    public void release(){
        lock.lock();
        try {
            ++permits;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }


}
