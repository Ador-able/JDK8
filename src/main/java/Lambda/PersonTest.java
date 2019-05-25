package main.java.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("AnYiMeng", "girl");
        Person person2 = new Person("LeiXinYu", "boy");
        Person person3 = new Person("WangWenHui", "girl");


        List<Person> personList = Arrays.asList(person1, person2, person3);

        System.out.println(getPersonsBySex("girl", personList));
        System.out.println(getPersonsByName("LeiXinYu", personList));
        System.out.println(getPersonsByFunction(new Person("", "girl"), personList, (person, people) ->
                people.stream().filter(p -> person.getSex().equals(p.getSex())).collect(Collectors.toList())
        ));
    }

    public static List<Person> getPersonsBySex(String sex, List<Person> people) {
        return people.stream().filter(person -> person.getSex().equals(sex)).collect(Collectors.toList());
    }

    public static List<Person> getPersonsByName(String name, List<Person> people) {
        BiFunction<String, List<Person>, List<Person>> biFunction = (s, lst) -> lst.stream().filter(person -> person.getName().equals(s)).collect(Collectors.toList());
        return biFunction.apply(name, people);
    }

    public static List<Person> getPersonsByFunction(Person person, List<Person> people, BiFunction<Person, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(person, people);
    }
}
