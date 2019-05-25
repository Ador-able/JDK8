package main.java.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Two {
    public static void main(String[] args) {
        MyInterfaceOne one = () -> {
        };
        System.out.println(one.getClass().getInterfaces()[0]);

        MyInterfaceTwo two = () -> {
        };
        System.out.println(two.getClass().getInterfaces()[0]);

        new Thread(() -> {
            System.out.println("Hello");
        }).start();

        List<String> list = Arrays.asList("Hello", "World");
        List<String> lst = new ArrayList<>();
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::print);
        System.out.println("\n=====================");
        list.stream().map(String::toUpperCase).forEach(System.out::print);
    }
}

@FunctionalInterface
interface MyInterfaceOne {
    void myMethodOne();
}

@FunctionalInterface
interface MyInterfaceTwo {
    void myMethodTwo();
}