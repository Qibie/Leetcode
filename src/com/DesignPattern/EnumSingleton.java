package com.DesignPattern;

public enum  EnumSingleton {
    instance;

    public void print(){
        System.out.println("heiehiehie");
    }
    public static void main(String[] args) {
        EnumSingleton enumSingleton=EnumSingleton.instance;
        EnumSingleton enumSingleton1=EnumSingleton.instance;
        System.out.println(enumSingleton==enumSingleton1);
        enumSingleton.print();
    }
}
