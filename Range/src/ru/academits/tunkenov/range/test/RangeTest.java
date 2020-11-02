package ru.academits.tunkenov.range.test;

import ru.academits.tunkenov.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class RangeTest {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        System.out.println("Сейчас мы рассчитаем длину диапазона и проверим входит ли число в этот диапазон.");
        System.out.println("Введите начальное число диапазона:");
        double from = scanner.nextDouble();

        System.out.println("Введите последнее число диапазона:");
        double to = scanner.nextDouble();

        Range range = new Range(from, to);

        double rangeLength = range.getLength();
        System.out.println("Длина диапазона = " + rangeLength);

        System.out.println("Введите число, чтобы мы проверили принадлежит оно диапазону или нет:");
        double number = scanner.nextDouble();

        boolean isInside = range.isInside(number);

        if (isInside) {
            System.out.println("Данное число входит в диапазон.");
        } else {
            System.out.println("Данное число не входит в диапазон.");
        }

        System.out.println("Мы можем поменять последнее число диапазона.");
        System.out.println("Введите последнее число диапазона:");
        range.setTo(scanner.nextDouble());

        rangeLength = range.getLength();

        System.out.println("Теперь длина диапазона = " + rangeLength);

        double rangeToNumber = number - range.getFrom();

        System.out.println("Диапазон от начального числа до числа, которое мы проверили = " + rangeToNumber);
*/
        Range range1 = new Range(1, 4);
        Range range2 = new Range(1, 2);

        Range crossingInterval = range1.getIntersection(range2);
        System.out.println("Интервал-пересечения = " + crossingInterval);

        Range[] combiningTwoIntervals = range1.getUnion(range2);
        System.out.println("Массив объединения двух диапозонов = " + Arrays.toString(combiningTwoIntervals));

        Range[] differenceOfTwoIntervals = range1.getDifference(range2);
        System.out.println("Массив разности двух диапозонов = " + Arrays.toString(differenceOfTwoIntervals));
    }
}
