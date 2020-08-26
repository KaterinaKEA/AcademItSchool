package academit.kondakova.range.main;

import academit.kondakova.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 10);

        double rangeLength = range.getLength();
        System.out.printf("Длина диапозона от %.2f до %.2f = %.2f%n", range.getFrom(), range.getTo(), rangeLength);

        range.setFrom(2);
        range.setTo(20);
        System.out.printf("Диапозон стал от %.2f до %.2f%n", range.getFrom(), range.getTo());

        System.out.println("Введите число для проверки принадлежности к диапозону:");
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        boolean isInside = range.isInside(number);
        System.out.printf("Введённое число внутри диапозона %b%n", isInside);

        Range range2 = new Range(10, 30);
        System.out.printf("Второй диапозон %.2f до %.2f%n", range2.getFrom(), range2.getTo());

        Range intersectionRanges = range.getIntersectionRanges(range2);

        if (intersectionRanges == null) {
            System.out.println("Диапозоны не пересекаются");
        } else {
            System.out.printf("Пересечение диапозонов %.2f до %.2f%n", intersectionRanges.getFrom(), intersectionRanges.getTo());
        }

        Range[] unionRange = range.getUnionRanges(range2);
        System.out.printf("Объединение диапозонов от %.2f до %.2f%n", unionRange[0].getFrom(), unionRange[0].getTo());

        if (unionRange.length == 2) {
            System.out.printf("и от %.2f до %.2f, так как диапозоны не пересекаются%n", unionRange[1].getFrom(), unionRange[1].getTo());
        }

        Range[] rangeDifference = range.getRangesDifference(range2);

        if (rangeDifference == null) {
            System.out.println("Разность диапозонов равна нулю, так как диапозоны совпадают");
        } else {
            System.out.printf("Разность диапозонов от %.2f до %.2f%n", rangeDifference[0].getFrom(), rangeDifference[0].getTo());

            if (rangeDifference.length == 2) {
                System.out.printf("и от %.2f до %.2f, так как диапозоны не пересекаются%n", rangeDifference[1].getFrom(), rangeDifference[1].getTo());
            }
        }
    }
}