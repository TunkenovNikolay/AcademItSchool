package ru.academits.tunkenov.my_array_list.test;

import ru.academits.tunkenov.my_array_list.MyArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> numbers1 = new MyArrayList<>();
        numbers1.add(20);
        numbers1.add(31);
        numbers1.add(10);
        //System.out.println(numbers1.remove(null));

        MyArrayList<Integer> numbers2 = new MyArrayList<>();
        numbers2.add(2);
        numbers2.add(4);
        numbers2.add(105);
        numbers2.add(222);
        numbers2.add(31);
        numbers2.add(22);
        numbers2.add(77);
        numbers2.add(103);

        /*System.out.println("Список numbers1 = " + numbers1);
        numbers1.addAll(numbers2);
        System.out.println("Список numbers1 = " + numbers1);

        numbers1.retainAll(numbers2);
        System.out.println("Список numbers1 = " + numbers1);
        System.out.println("Список numbers2 = " + numbers2);*/
        numbers1.addAll(1, numbers2);
        System.out.println(numbers1);
    }
}
