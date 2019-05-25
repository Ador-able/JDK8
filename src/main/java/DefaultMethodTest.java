package main.java;

interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}
class ClassA implements InterfaceA {
}
public class DefaultMethodTest {
    public static void main(String[] args) {
        new ClassA().foo(); // 打印：“InterfaceA foo”
    }
}