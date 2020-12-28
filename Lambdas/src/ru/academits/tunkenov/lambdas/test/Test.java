package ru.academits.tunkenov.lambdas.test;

import ru.academits.tunkenov.lambdas.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Ivan", 13),
                new Person("Petr", 16),
                new Person("Nikolay", 26),
                new Person("Dmitriy", 29),
                new Person("Alexandr", 35),
                new Person("Vasiliy", 38),
                new Person("Ivan", 27)
        );

        List<String> uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Уникальные имена из списка persons: " + uniqueNames);

        System.out.println(uniqueNames.stream().collect(Collectors.joining(", ", "Имена: ", ".")));

        List<Person> personsUnder18 = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        Double averageAgeUnder18 = personsUnder18.stream()
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.println("Средний возраст людей младше 18 лет: " + averageAgeUnder18);

        Map<String, Double> averageAgeByNames = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.averagingDouble(Person::getAge)
                ));

        System.out.println("Средний возраст людей с одинаковым именем:" + averageAgeByNames);

        persons.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((s1, s2) -> s2.getAge() - s1.getAge())
                .forEach(System.out::println);
    }
}
