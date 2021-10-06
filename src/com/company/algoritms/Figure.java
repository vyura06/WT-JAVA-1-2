package com.company.algoritms;

import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class Figure {
    public static boolean contains(double yMin, double yMax,
                                   double x1, double x2,
                                   double x, double y) {
        return contains(yMin, 0, yMax, -x1, x1, -x2, x2, x, y);
    }

    public static boolean contains(double yMin, double yDelimiter, double yMax,
                                   double xMin1, double xMax1,
                                   double xMin2, double xMax2,
                                   double x, double y) {
        if (y > yDelimiter) {
            return (y <= yMax) && contains(xMin1, xMax1, x);
        } else {
            return (y >= yMin) && contains(xMin2, xMax2, x);
        }
    }

    public static boolean contains(double min, double max, double x) {
        return x >= min && x <= max;
    }

    public static void main(String[] args) {
        final String cancel = "cancel";
        Scanner scanner = new Scanner(System.in);
        try {
            double yMin = InputUtils.readDouble(scanner, "Enter yMin: ", cancel);
            double yMax = InputUtils.readDouble(scanner, "Enter yMax: ", cancel);

            double x1 = InputUtils.readDouble(scanner, "Enter x1: ", cancel);
            double x2 = InputUtils.readDouble(scanner, "Enter x2: ", cancel);

            while (true) {
                System.out.println("Do you want to check the point? [Yes=yes,No=other]");
                String token = scanner.nextLine();
                if (!"yes".equals(token))
                    break;
                double x = InputUtils.readDouble(scanner, "Enter x: ", cancel);
                double y = InputUtils.readDouble(scanner, "Enter y: ", cancel);

                boolean contains = contains(yMin, yMax, x1, x2, x, y);
                System.out.println("Contains? " + contains);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Figure creation error");
        } catch (CancellationException ignored) {
        }
    }
}
