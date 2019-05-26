package main.java;

import main.java.Lambda.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//一般用来规避空指针异常
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello");

        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        //推荐使用的方式
        //利用Consumer实现
        optional.ifPresent(s -> System.out.println(s));
        System.out.println("========================");


        Optional<String> optional1 = Optional.empty();
        System.out.println(optional1.orElse("World"));
        System.out.println("========================");
        System.out.println(optional1.orElseGet(() -> "Hi"));
        System.out.println("========================");

        //return value == null ? empty() : of(value);
        Optional<String> optional2 = Optional.ofNullable("Love");//等价于of
        optional2.ifPresent(System.out::println);

        System.out.println("========================");
        Company company = new Company();
        company.addPerson(new Person("LXY", "boy"));
        company.addPerson(new Person("AYM", "girl"));
        Optional<Company> optional3 = Optional.ofNullable(company);
        System.out.println(optional3.map(thecompany -> thecompany.getPeople()).orElse(Collections.emptyList()));
    }
}

class Company {
     List<Person> people;

    public Company() {

    }

    public List<Person> getPeople() {
        return people;
    }


    public void addPerson(Person person) {
        if (people == null)
            people = new ArrayList<>();
        people.add(person);
    }

    @Override
    public String toString() {
        return "Company{" +
                "people=" + people +
                '}';
    }
}