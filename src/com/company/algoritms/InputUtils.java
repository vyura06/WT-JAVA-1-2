package com.company.algoritms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class InputUtils {
    public static double readDouble(Scanner scanner, String msg, String cancel) throws CancellationException {
        System.out.println(msg);
        return readDouble(scanner, cancel);
    }

    public static double readDouble(Scanner scanner, String cancel) throws CancellationException {
        while (true) {
            String s = scanner.next();
            try {
                double value = Double.parseDouble(s);
                scanner.nextLine();
                return value;
            } catch (NumberFormatException e) {
                if (cancel == null || cancel.equals(s)) {
                    throw new CancellationException();
                }
                System.err.println("This is not number, enter: \"" + cancel + "\", to cancel");
            }
        }
    }

    public static double[] readArray(Scanner scanner) {
        System.out.println("Enter input method:\n1 - fixed size\n2 - \"stop\" word");
        String token = scanner.nextLine();
        switch (token) {
            case "1": {
                int size = (int) InputUtils.readDouble(scanner, "Enter size", "cancel");
                System.out.println("Enter numbers:");
                double[] array = new double[size];
                for (int i = 0; i < array.length; i++) {
                    array[i] = readDouble(scanner, null);
                }
                return array;
            }
            case "2": {
                int size = 0;
                double[] array = new double[16];
                System.out.println("Enter \"stop\" word:");
                String stop = scanner.nextLine();
                System.out.println("Enter numbers:");
                while (true) {
                    try {
                        if (size == array.length)
                            array = Arrays.copyOf(array, array.length * 2);
                        array[size++] = readDouble(scanner, stop);
                    } catch (CancellationException e) {
                        return Arrays.copyOf(array, size);
                    }
                }
            }
            default:
                throw new IllegalStateException("Unexpected value: " + token);
        }
    }
}
