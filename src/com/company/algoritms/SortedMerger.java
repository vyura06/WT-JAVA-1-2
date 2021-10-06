package com.company.algoritms;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SortedMerger {
    public static int binarySearch(double key, double[] array,
                                   int low, int high) {
        Objects.requireNonNull(array);
        Objects.checkFromToIndex(low, high, array.length);

        while (low < high) {
            int mid = (low + high - 1) >>> 1;
            int c = Double.compare(array[mid], key);
            if (c < 0)
                low = mid + 1;
            else if (c > 0)
                high = mid;
            else
                return mid;
        }
        return -(low + 1);
    }

    public static double[] merge(double[] a, double[] b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);

        int len = a.length + b.length;
        if (len == 0)
            return new double[0];

        int resultSize = a.length;
        double[] array = new double[len];
        System.arraycopy(a, 0, array, 0, resultSize);

        for (double element : b) {
            int destPos = binarySearch(element, array, 0, resultSize);
            if (destPos < 0)
                destPos = (-destPos) - 1;

            System.arraycopy(array, destPos, array, destPos + 1, resultSize - destPos);
            array[destPos] = element;
            resultSize++;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sorted array");
        double[] a = InputUtils.readArray(scanner);

        System.out.println("Enter sorted array");
        double[] b = InputUtils.readArray(scanner);

        System.out.println("First array");
        System.out.println(Arrays.toString(a));

        System.out.println("Second array");
        System.out.println(Arrays.toString(b));

        double[] merge = merge(a, b);

        System.out.println("Merged array");
        System.out.println(Arrays.toString(merge));
    }
}
