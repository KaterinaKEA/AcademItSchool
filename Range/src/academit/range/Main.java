package academit.range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 10);

        double rangeLength = range.getLength();
        System.out.printf("Длина диапозона от %.2f до %.2f = %.2f%n", range.getFrom(), range.getTo(), rangeLength);

        range.setTo(20);
        System.out.printf("Диапозон стал от %.2f до %.2f%n", range.getFrom(), range.getTo());

        System.out.println("Введите число для проверки принадлежности к диапозону:");
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        boolean isInside = range.isInside(number);
        System.out.printf("Введённое число внутри диапозона %b%n", isInside);

        Range range2 = new Range(10, 30);
        Range intersectionRanges = Range.getIntersectionRanges(range, range2);

        if (intersectionRanges == null) {
            System.out.println("Диапозоны не пересекаются");
        } else {
            System.out.printf("Пересечение диапозонов %.2f до %.2f%n", intersectionRanges.getFrom(), intersectionRanges.getTo());
        }


    }
}
