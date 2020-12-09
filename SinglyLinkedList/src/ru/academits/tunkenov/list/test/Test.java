package ru.academits.tunkenov.list.test;

import ru.academits.tunkenov.list.SinglyLinkedList;

public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> numbers1 = new SinglyLinkedList<>();
        System.out.println(numbers1);

        numbers1.add(4);
        numbers1.add(2);
        numbers1.add(3);
        numbers1.add(null);
        numbers1.add(1);
        numbers1.addFirst(25);
        numbers1.add(222);
        numbers1.add(2323232);

        SinglyLinkedList<Integer> numbers2 = numbers1.copy();

        System.out.println(numbers1);
        System.out.println(numbers2);

        System.out.println(numbers1.remove(2));
        System.out.println(numbers1);
        System.out.println(numbers2);
        System.out.println(numbers1);

        numbers1.add(2, 305);

        System.out.println(numbers1);
        System.out.println(numbers1.setData(2, 11));
        System.out.println(numbers1.getData(2));

        System.out.println(numbers1);
        System.out.println(numbers1.removeFirst());
        System.out.println(numbers1.getData(0));
        System.out.println(numbers1);

        System.out.println(numbers1.remove(1));
        System.out.println(numbers1);
    }
}
