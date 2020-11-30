package ru.academits.tunkenov.list.test;
import ru.academits.tunkenov.list.SinglyLinkedList;

public class Test {
    public static void main(String[] args) {
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = null;
        Integer six = 6;

        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();

        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);

        System.out.println(numbers);
        System.out.println(numbers.removeFirst());
        System.out.println(numbers);
    }
}
