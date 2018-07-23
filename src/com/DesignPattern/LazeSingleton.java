package com.DesignPattern;

/**
 * 懒汉式是典型的时间换空间,就是每次获取实例都会进行判断，
 * 看是否需要创建实例，浪费判断的时间。当然，如果一直没有人使用的话，
 * 那就不会创建实例，则节约内存空间
 * <p>
 * 由于懒汉式的实现是线程安全的，这样会降低整个访问的速度，而且每次都要判断。
 */

public class LazeSingleton {
    private static LazeSingleton instance = null;

    private static volatile LazeSingleton instance_1 = null;

    private LazeSingleton() {
    }

    public static synchronized LazeSingleton getInstance() {
        if (instance == null) {
            instance = new LazeSingleton();
        }
        return instance;
    }


    public static LazeSingleton getInstance_1() {
        if (instance_1 == null) {
            synchronized (LazeSingleton.class) {
                if (instance_1 == null) {
                    instance_1 = new LazeSingleton();
                }
            }
        }
        return instance_1;
    }


}
