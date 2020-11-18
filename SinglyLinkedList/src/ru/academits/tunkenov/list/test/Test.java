package ru.academits.tunkenov.list.test;

import ru.academits.tunkenov.list.ListItem;
import ru.academits.tunkenov.list.SinglyLinkedList;

public class Test {
    public static void main(String[] args) {
        ListItem<Integer> one = new ListItem<>(1);
        ListItem<Integer> two = new ListItem<>(2);
        ListItem<Integer> three = new ListItem<>(3);
        ListItem<Integer> four = new ListItem<>(4);
        ListItem<Integer> five = new ListItem<>(5);
        ListItem<Integer> six = new ListItem<>(6);
        ListItem<Integer> twelve = new ListItem<>(12);
        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> numbers2 = new SinglyLinkedList<>();
        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(0, four);
        numbers.add(five);
        numbers.add(six);

        numbers2.add(twelve);

        SinglyLinkedList.copy(numbers, numbers2);
        numbers2.printList();
    }
}
