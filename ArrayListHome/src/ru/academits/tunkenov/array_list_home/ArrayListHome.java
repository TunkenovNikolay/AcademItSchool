package ru.academits.tunkenov.array_list_home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static ArrayList<String> getLines(File file) {
        ArrayList<String> fileLines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                fileLines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл, который необходимо прочитать не найден.");
        }

        return fileLines;
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
        ArrayList<Integer> uniqueNumbers = new ArrayList<>(numbers.size());

        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }

        return uniqueNumbers;
    }

    public static void main(String[] args) {
        File file = new File("lines.txt");
        ArrayList<String> fileStrings = getLines(file);
        System.out.println("Строки прочитанные из файла lines: " + fileStrings);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 3, 3, 4, 2, 5, 3, 3, 6, 7, 8, 9, 10));
        removeEvenNumbers(numbers);
        System.out.println("Распечатан список numbers после удаления четных чисел: " + numbers);

        ArrayList<Integer> uniqueNumbers = getUniqueNumbers(numbers);
        System.out.println("Распечатан список uniqueNumbers: " + uniqueNumbers);
    }
}

