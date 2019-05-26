package main.java.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        //创建流对象
        Stream stream1 = Stream.of("1", "2", "3");
        String[] strings = {"1", "2", "3"};
        Stream stream2 = Stream.of(strings);
        Stream stream3 = Arrays.stream(strings);
        List<String> list = Arrays.asList(strings);
        Stream stream4=list.stream();

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        //intStream.forEach(System.out::println);
        System.out.println("================");
        IntStream.range(3,5).forEach(System.out::println);
        System.out.println("================");
        IntStream.rangeClosed(3,5).forEach(System.out::println);

        System.out.println("================");
        //对元素进行转换使用map
        int reduce = intStream.map(operand -> operand * 2).reduce(0, Integer::sum);
        System.out.println(reduce);


        System.out.println("================");
        Stream<String> stream5 = Stream.of("1", "2", "3");
        String[] strs = stream5.toArray(String[]::new);
        Arrays.stream(strs).forEach(System.out::println);


        System.out.println("================");
        Stream<String> stream6 = Stream.of("1", "2", "3");
        List<String> collect1 = stream6.collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("================\ncollect");
        Stream<String> stream7 = Stream.of("1", "2", "3");
        //List<String> collect2 = stream7.collect(() -> new ArrayList(),(arrayList, s) -> arrayList.add(s),(arrayList, arrayList2) -> arrayList.addAll(arrayList2));
        List<String> collect2 = stream7.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
        collect2.forEach(System.out::println);
    }
}
