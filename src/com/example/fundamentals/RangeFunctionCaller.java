package com.example.fundamentals;

import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class RangeFunctionCaller {
    public static void callFunctionOnRange(double x, double b, double h) {
        while (x < b) {
            System.out.printf("x = %.5f, F(x) = %.5f \n", x, Math.tan(x));
            x += h;
        }
    }

    public static void main(String[] args) {
        try {
            String cancel = "cancel";
            Scanner scanner = new Scanner(System.in);

            double a = Input.readDouble(scanner, "Enter a:", cancel);
            double b = Input.readDouble(scanner, "Enter b:", cancel);
            double h = Input.readDouble(scanner, "Enter h:", cancel);

            callFunctionOnRange(a, b, h);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() == null ? "Error" : e.getMessage());
        } catch (CancellationException ignored) {
        }
    }
}
