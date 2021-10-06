package com.company.algoritms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class Sort {
    public static void sort(double[] array) {
        int i = 1;
        int j = i + 1;
        while (i < array.length) {
            if (i <= 0 || Double.compare(array[i - 1], array[i]) <= 0) {
                i = j;
                j++;
            } else {
                double tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            double[] array = InputUtils.readArray(scanner);
            System.out.println("Your array:");
            System.out.println(Arrays.toString(array));

            sort(array);

            System.out.println("Sorted array:");
            System.out.println(Arrays.toString(array));
        } catch (CancellationException ignored) {
        }
    }
}
