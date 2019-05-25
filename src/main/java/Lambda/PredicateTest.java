package main.java.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 5;

        //验证参数是否满足某种条件
        System.out.println(predicate.test("hello"));


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        conditionFilter(list, integer -> integer % 3 == 0);
        System.out.println("=======================");
        conditionFilter(list, integer -> integer > 5);
        System.out.println("=======================");
        conditionFilter(list, integer -> true);
        System.out.println("=======================");

        conditionsFilter(list,integer -> integer % 3 == 0,integer -> integer > 5);

        System.out.println("=======================");
        System.out.println(Predicate.isEqual("Test").test("Test"));
    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }

    public static void conditionsFilter(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.stream().filter(predicate1.and(predicate2)).forEach(System.out::println);
        System.out.println("=======================");
        list.stream().filter(predicate1.negate()).forEach(System.out::println);
        System.out.println("=======================");
        list.stream().filter(predicate1.or(predicate2)).forEach(System.out::println);
    }
}
