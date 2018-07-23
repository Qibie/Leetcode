package org.fenixsoft.clazz;

class Human {
    public static String staticValue = "human";
    public String value = "human";

    public void print() {
        System.out.println("i am a human");
    }

    public static void staticPrint() {
        System.out.println("human static print");
    }


}

class Man extends Human {
    public static String staticValue = "man";
    public String value = "man";

    public void print() {
        System.out.println("i am a man");
    }

    public static void staticPrint() {
        System.out.println("man static print");
    }
}

class Woman extends Human {
    public static String staticValue = "woman";
    public String value = "woman";

    public void print() {
        System.out.println("i am a woman");
    }

    public static void staticPrint() {
        System.out.println("woman static print");
    }
}


public class StaticFMethodOverwirte {

    public void sayHello(Human human) {
        System.out.println("hello guy!");
    }


    public void sayHello(Man man) {
        System.out.println("hello man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        System.out.println(man.value);
        System.out.println(woman.value);
        System.out.println("********************************");
        System.out.println(((Man) man).value);
        System.out.println(((Woman) woman).value);
        System.out.println("******************************");
        System.out.println(man.staticValue);
        System.out.println(woman.staticValue);
        System.out.println("*******************************");
        System.out.println(((Man) man).staticValue);
        System.out.println(((Woman) woman).staticValue);
        System.out.println("*******************************");
        man.print();
        woman.print();
        System.out.println("*****************************");
        man.staticPrint();
        woman.staticPrint();
        System.out.println("*****************************");
        StaticFMethodOverwirte staticFMethodOverwirte = new StaticFMethodOverwirte();
        staticFMethodOverwirte.sayHello(man);
        staticFMethodOverwirte.sayHello(woman);
        System.out.println("*****************************");


    }


}
