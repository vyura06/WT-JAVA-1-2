package com.company.oop.baskets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private final ArrayList<Ball> balls = new ArrayList<>();

    public Basket() {
    }

    public int totalWeight() {
        int sum = 0;
        for (Ball ball : balls)
            sum += ball.getWeight();
        return sum;
    }

    public int countByColor(Color color) {
        Objects.requireNonNull(color);
        int count = 0;
        for (Ball ball : balls) {
            if (color.equals(ball.getColor())) {
                count++;
            }
        }
        return count;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
