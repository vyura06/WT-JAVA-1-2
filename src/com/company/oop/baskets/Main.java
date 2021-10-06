package com.company.oop.baskets;

import com.company.algoritms.InputUtils;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Basket basket = new Basket();
    private static boolean running = true;

    private static String cancel = Command.EXIT.getKey();
    private static String help;

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner("\n", "", "\nColors:" + Arrays.toString(Color.values()));
        for (Command value : Command.values()) {
            joiner.add(value.infoString());
        }
        help = joiner.toString();

        System.out.println(help);
        do {
            try {
                System.out.println("Enter command");
                String token = scanner.nextLine();
                Optional<Command> optionalCommand = Arrays.stream(Command.values()).
                        filter(c -> c.getKey().
                                equals(token)).findFirst();
                if (optionalCommand.isEmpty()) {
                    System.err.println("Invalid command");
                } else {
                    handleCommand(optionalCommand.get());
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage() == null ? "Invalid input" : e.getMessage());
            }
        } while (running);
    }


    private static void handleCommand(Command command) {
        switch (command) {
            case HELP:
                System.out.println(help);
                break;
            case ADD:
                try {
                    System.out.println("Enter color");
                    String name = scanner.nextLine();
                    Color color = Color.valueOf(name.toUpperCase(Locale.ROOT));
                    int weight = (int) InputUtils.readDouble(scanner, "Enter weight:", cancel);
                    Ball ball = new Ball(color, weight);
                    basket.getBalls().add(ball);
                } catch (IllegalArgumentException e) {
                    System.err.println("Choose one of the colors from the list:");
                    System.err.println(Arrays.toString(Color.values()));
                }
                break;
            case REMOVE:
                if (basket.getBalls().isEmpty()) {
                    System.out.println("Basket is empty");
                    break;
                }
                int index = (int) InputUtils.readDouble(scanner, "Enter index from 1 to " + basket.getBalls().size() + ":", cancel);
                try {
                    basket.getBalls().remove(index - 1);
                } catch (IndexOutOfBoundsException e) {
                    System.err.println(e.getMessage() == null ? "Invalid index" : e.getMessage());
                }
                break;
            case CLEAR:
                basket.getBalls().clear();
                break;
            case PRINT:
                System.out.println("Basket:");
                basket.getBalls().forEach(System.out::println);
                System.out.println();
                break;
            case TOTAL_WEIGHT:
                System.out.println(basket.totalWeight());
                break;
            case BLUE_BALL_COUNT:
                System.out.println(basket.countByColor(Color.BLUE));
                break;
            case EXIT:
                running = false;
                break;
        }
    }
}

