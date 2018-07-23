package org.fenixsoft.clazz;

class A {
    static {
        System.out.println("A.init");
    }

    public int value = 0;
}


public class LoadClassTest {
    public static void main(String[] args) {
        A[] as = new A[10];
        int[] ints = new int[10];
        System.out.println(ints[1]);
    }
}
