package ru.academits.tunkenov.lambdas.test;

import ru.academits.tunkenov.lambdas.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Person ivan = new Person("Ivan", 13);
        Person petr = new Person("Petr", 16);
        Person nikolay = new Person("Nikolay", 26);
        Person dmitriy = new Person("Dmitriy", 29);
        Person alexandr = new Person("Alexandr", 35);
        Person vasiliy = new Person("Vasiliy", 38);

        List<Person> persons = new ArrayList<>(Arrays.asList(ivan, petr, nikolay, dmitriy, alexandr, vasiliy));

        List<String> uniqueNames = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueNames);

        uniqueNames.forEach(p -> {
            if (p.equals(uniqueNames.get(0))) {
                System.out.print("Имена: ");
            }

            if (!p.equals(uniqueNames.get(uniqueNames.size() - 1))) {
                System.out.print(p + ", ");
            } else {
                System.out.println(p + ".");
            }
        });

        List<Person> personsUndo18 = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        Double averageAgeUndo18 = personsUndo18.stream()
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.println(averageAgeUndo18);

        Double averageAge = persons.stream()
                .collect(Collectors.averagingInt(Person::getAge));

        Map<String, Double> personsMap = persons.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        p -> averageAge));

        System.out.println(personsMap);

        persons.stream()
                .filter(p -> p.getAge() > 20 && p.getAge() < 45)
                .sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
                .forEach(System.out::println);
    }
}
