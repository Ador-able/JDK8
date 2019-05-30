package main.java.Stream;

import main.java.Lambda.Person;

import java.util.*;

import static java.util.stream.Collectors.*;

public class CollectorsTest {
    public static void main(String[] args) {
        Person person1=new Person("aym","girl",22);
        Person person2=new Person("wzh","girl",22);
        Person person3=new Person("hd","girl",16);
        Person person4=new Person("lxy","boy",12);
        Person person5=new Person("lh","boy",18);
        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5);

        List<Person> collect = people.stream().collect(toList());
        collect.stream().forEach(System.out::println);

        System.out.println("================");
        Long aLong = people.stream().collect(counting());
        long count = people.stream().count();
        System.out.println(aLong+" "+count);

        System.out.println("================");
        Optional<Person> collect1 = people.stream().collect(minBy(Comparator.comparingInt(Person::getAge)));
        collect1.ifPresent(System.out::println);

        System.out.println("================");
        Map<String, Map<Integer, List<Person>>> collect2 = people.stream().collect(groupingBy(Person::getSex, groupingBy(Person::getAge)));
        collect2.forEach((s, integerListMap) ->System.out.println(s+" "+integerListMap.toString()) );

        System.out.println("================");
        Map<String, Person> collect3 = people.stream().collect(groupingBy(Person::getSex, collectingAndThen(minBy(Comparator.comparingInt(Person::getAge)), Optional::get)));
        collect3.forEach((s, person) -> System.out.println(s+" "+person.toString()));

        System.out.println("================");
        TreeMap<String, Set<Person>> collect4 = people.stream().collect(groupingBy(Person::getSex, TreeMap::new, toSet()));
        collect4.forEach((s, person) -> System.out.println(s+" "+person.toString()));
    }
}
