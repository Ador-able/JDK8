package main.java.Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hi", "aym", "why", "ignore", "me");

        //Collections.sort(list);
        Collections.sort(list, Comparator.comparingInt(String::length));

        Collections.sort(list,Comparator.comparingInt(String::length).reversed());

        list.sort(Comparator.comparingInt(String::length));

        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));

        //最后一个thenComparing不起作用想想为什么
        Collections.sort(list,Comparator.comparingInt(String::length).reversed().thenComparing(String::toLowerCase,Comparator.reverseOrder()).thenComparing(Comparator.reverseOrder()));

        System.out.println(list);
    }
}
