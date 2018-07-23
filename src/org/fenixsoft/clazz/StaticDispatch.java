package org.fenixsoft.clazz;

public class StaticDispatch {
    class Human {
        public void print() {
            System.out.println("I am a human");
        }

    }

    class Man extends Human {

        public void print() {
            System.out.println("i am a man");
        }


    }

    class Woman extends Human {
        public void print() {
            System.out.println("i am a woman");
        }
    }


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
        StaticDispatch sd = new StaticDispatch();
        Human man = sd.new Man();
        Human womad = sd.new Woman();
        sd.sayHello(man);
        sd.sayHello(womad);
        System.out.println("");
        man.print();
        womad.print();

        System.out.println(man instanceof StaticDispatch.Human);

    }

}




