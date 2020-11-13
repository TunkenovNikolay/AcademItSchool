package ru.academits.tunkenov.array_list_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("numbers.txt"))) {
            scanner.useDelimiter(", ");

            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }

            System.out.println(numbers);
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }

        System.out.println(numbers);

        ArrayList<Integer> uniqueNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (uniqueNumbers.contains(numbers.get(i))) {
                i++;
                continue;
            }

            uniqueNumbers.add(numbers.get(i));
        }

        System.out.println(uniqueNumbers);
    }
}

