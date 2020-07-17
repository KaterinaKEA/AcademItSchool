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
        System.out.printf("Введённое число внутри диапозона %b", isInside);
    }
}
