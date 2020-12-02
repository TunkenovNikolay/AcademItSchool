package ru.academits.tunkenov.array_list_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void readLines(ArrayList<String> lines) {
        try (Scanner scanner = new Scanner(new FileInputStream("lines.txt")).useDelimiter("//n")) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл, который необходимо прочитать не найден.");
        }
    }

    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
    }

    public static ArrayList<Integer> getUniqueNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        uniqueNumbers.ensureCapacity(numbers.size());

        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }

        uniqueNumbers.trimToSize();

        return uniqueNumbers;
    }

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        readLines(lines);
        System.out.println(lines);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 3, 3, 4, 2, 5, 3, 3, 6, 7, 8, 9, 10));
        removeEvenNumbers(numbers);
        System.out.println(numbers);

        ArrayList<Integer> uniqueNumbers = getUniqueNumbers(numbers);
        System.out.println(uniqueNumbers);
    }
}

