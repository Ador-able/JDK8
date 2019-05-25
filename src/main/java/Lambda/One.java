package main.java.Lambda;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class One {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(" "+list.get(i));
        }

        System.out.println("\n=====================");

        for (Integer i : list) {
            System.out.print(" "+i);
        }

        System.out.println("\n=====================");

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(" "+integer);
            }
        });

        System.out.println("\n=====================");

        list.forEach(integer -> {
            System.out.print(" "+integer);
        });

        System.out.println("\n=====================");

        //method reference
        list.forEach( System.out::print);
    }
}
