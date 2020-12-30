package ru.academits.tunkenov.tree.test;

import ru.academits.tunkenov.tree.Tree;

public class test {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(Integer::compareTo);
        tree.add(25);
        tree.add(10);
        tree.add(26);
        tree.add(28);
        tree.add(1);
        tree.add(2);
        tree.add(100);
        tree.add(50);
        tree.add(35);
        System.out.println("Содержит ли tree элемент 25: " + tree.find(25));
        //System.out.println(tree.remove(26));
        tree.BFS(System.out::println);

    }
}
