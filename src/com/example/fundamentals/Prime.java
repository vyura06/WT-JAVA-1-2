package com.example.fundamentals;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Prime {
    public static int[] primeNumberIndexes(int[] numbers) {
        Objects.requireNonNull(numbers);

        final int len = numbers.length;
        if (len == 0)
            return new int[0];

        int size = 0;
        int[] indexes = new int[len];

        for (int i = 0; i < len; i++) {
            if (isPrime(numbers[i])) {
                indexes[size++] = i;
            }
        }
        if (size == 0)
            return new int[0];
        if (size == len)
            return indexes;
        return Arrays.copyOf(indexes, size);
    }

    public static boolean isPrime(long number) {
        if (number < 2)
            return false;
        for (long i = 2; i * i <= number; i ++)
            if (number % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(Input.readArray(scanner)).
                mapToInt(value -> (int) value).toArray();

        System.out.println("Your array:");
        System.out.println(Arrays.toString(array));

        int[] primeNumberIndexes = primeNumberIndexes(array);

        if (primeNumberIndexes.length == 0) {
            System.out.println("Prime number not found");
        } else {
            System.out.println("Prime number numbers:");
            int[] primeNumberNumbers = Arrays.stream(primeNumberIndexes).map(i -> i + 1).toArray();
            System.out.println(Arrays.toString(primeNumberNumbers));
        }
    }
}