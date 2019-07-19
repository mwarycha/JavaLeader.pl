package pl.javaleader.interfaces;

interface InterfacesDemo {
    default void printMsg(Object msg) {
        System.out.println("[log]" + " " + msg);
    }

    static void getInfo() {
        System.out.println("changes in interfaces in java 8");
    }

}

public class InterfacesMainDemo {

    public static void main(String[] args) {

        InterfacesDemo interfacesDemo = new InterfacesDemo() {

        };

        interfacesDemo.printMsg("somethind msg");
        InterfacesDemo.getInfo();

    }

}
