package ru.academits.tunkenov.array_list_home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static ArrayList<String> readLines(File file) {
        ArrayList<String> readLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                readLines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл, который необходимо прочитать не найден.");
        }

        return readLines;
    }

    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
    }

    public static ArrayList<Integer> getUniqueNumbers(ArrayList<Integer> numbers, int capacity) {
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        uniqueNumbers.ensureCapacity(capacity);

        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }

        return uniqueNumbers;
    }

    public static void main(String[] args) {
        File file = new File("lines.txt");
        ArrayList<String> lines = readLines(file);
        System.out.println("Строки прочитанные из файла lines: " + lines);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 3, 3, 4, 2, 5, 3, 3, 6, 7, 8, 9, 10));
        removeEvenNumbers(numbers);
        System.out.println("Распечатан список numbers после удаления четных чисел: " + numbers);

        ArrayList<Integer> uniqueNumbers = getUniqueNumbers(numbers, 5);
        System.out.println("Распечатан список uniqueNumbers: " + uniqueNumbers);
    }
}

