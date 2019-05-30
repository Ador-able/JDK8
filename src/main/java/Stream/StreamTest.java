package main.java.Stream;

import main.java.Lambda.Person;

import java.util.*;
import java.util.stream.Collector;
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
        Stream stream4 = list.stream();

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        //intStream.forEach(System.out::println);
        System.out.println("================");
        IntStream.range(3, 5).forEach(System.out::println);
        System.out.println("================");
        IntStream.rangeClosed(3, 5).forEach(System.out::println);

        System.out.println("================");
        //对元素进行转换使用map
        int reduce = intStream.map(operand -> operand * 2).reduce(0, Integer::sum);
        System.out.println(reduce);


        System.out.println("================");
        Stream<String> stream5 = Stream.of("1", "2", "3");
        String[] strs = stream5.toArray(String[]::new);
        Arrays.stream(strs).forEach(System.out::println);


        //Collector提供集合的聚合
        System.out.println("================");
        Stream<String> stream6 = Stream.of("1", "2", "3");
        List<String> collect1 = stream6.collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("================\ncollect");
        Stream<String> stream7 = Stream.of("1", "2", "3");
        //List<String> collect2 = stream7.collect(() -> new ArrayList(),(arrayList, s) -> arrayList.add(s),(arrayList, arrayList2) -> arrayList.addAll(arrayList2));
        List<String> collect2 = stream7.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        collect2.forEach(System.out::println);

        System.out.println("================");
        //set会自动进行排序
        Stream<String> stream8 = Stream.of("2", "1", "3");
        TreeSet<String> treeSet = stream8.collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);

        System.out.println("================");
        Stream<String> stream9 = Stream.of("2", "1", "3");
        String s = stream9.collect(Collectors.joining());
        System.out.println(s);

        System.out.println("================");
        Stream<String> stream10 = Stream.of("hello", "aym", "lxy");
        List<String> collect3 = stream10.map(String::toUpperCase).collect(Collectors.toList());
        collect3.forEach(System.out::println);

        System.out.println("================");
        //flatMap把所有的List连接成一个list
        Stream<List<Integer>> stream11 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        List<Integer> collect4 = stream11.flatMap(integers -> integers.stream().map(integer -> integer * integer)).collect(Collectors.toList());
        collect4.forEach(System.out::println);

        System.out.println("================");
        Stream<String> stream12 = Stream.generate(UUID.randomUUID()::toString);
        Optional<String> first = stream12.findFirst();
        first.ifPresent(System.out::println);

        //对seed无限制执行表达式中的操作。配合limit执行6次
        System.out.println("================");
        Stream<Integer> stream13 = Stream.iterate(1, t -> t + 2).limit(6);
        stream13.forEach(System.out::println);

        System.out.println("================");
        IntStream intStream1 = IntStream.of(1, 3, 5, 7, 9, 11);
        int sum = intStream1.filter(value -> value > 2).map(operand -> operand * 2).skip(2).limit(2).sum();
        System.out.println(sum);

        System.out.println("================");
        IntStream intStream2 = IntStream.of(1, 3, 5, 7, 9, 11);
        IntSummaryStatistics intSummaryStatistics = intStream2.filter(value -> value > 2).map(operand -> operand * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());

        System.out.println("================");
        Stream<String> stream14 = Stream.of("hello", "aym", "lxy");
        stream14.mapToInt(value -> value.length()).filter(value -> value == 3).findFirst().ifPresent(System.out::println);

        System.out.println("================");
        Stream<String> stream15 = Stream.of("hello", "aym", "lxy");
        stream15.mapToInt(value ->
                {
                    int len = value.length();
                    System.out.println(value);
                    return len;
                }
        ).filter(value -> value == 3).findFirst().ifPresent(System.out::println);

        System.out.println("================");
        //重要
        Stream<String> stream16 = Stream.of("hello", "aym does not love lxy", "lxy say hello to aym");
        stream16.map(s1 -> s1.split(" ")).flatMap(strings1 -> Arrays.asList(strings1).stream()).distinct().forEach(System.out::println);

        System.out.println("================");
        //分组
        List<String> list1 = Arrays.asList("hello", "hi");
        List<String> list2 = Arrays.asList("lxy", "aym");
        //list1.stream().forEach(s1 -> list2.stream().forEach(s2->System.out.println(s1+" "+s2)));
        list1.stream().flatMap(s1 -> list2.stream().map(s2 -> s1 +" "+s2)).forEach(System.out::println);


        System.out.println("================");
        Person person1=new Person("aym","girl",22);
        Person person2=new Person("wzh","girl",22);
        Person person3=new Person("hd","girl",16);
        Person person4=new Person("lxy","boy",12);
        Person person5=new Person("lh","boy",18);
        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5);
        Map<String, List<Person>> collect = people.stream().collect(Collectors.groupingBy(Person::getSex));
        collect.forEach((s1, people1) -> System.out.println(s1+" "+people1.toString()));
        Map<String, Long> collect5 = people.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.counting()));
        collect5.forEach((s1, aLong) ->  System.out.println(s1+" "+aLong));
        Map<String, Double> collect6 = people.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.averagingDouble(value -> value.getAge())));
        collect6.forEach((s1, aDouble) -> System.out.println(s1+" "+aDouble));
        //多条件分组
        Map<String, List<Person>> collect7 = people.stream().collect(Collectors.groupingBy(Person::groupBySexAndAge));
        collect7.forEach((s1, people1) -> System.out.println(s1+" "+people1));
        Map<Boolean, List<Person>> collect8 = people.stream().collect(Collectors.partitioningBy(o -> o.getSex() == "girl"));
        collect8.forEach((s1, people1) -> System.out.println(s1+" "+people1));
    }
}
