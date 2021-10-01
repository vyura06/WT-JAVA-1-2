package com.example.classes.BasketBall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Basket extends ArrayList<Ball> {
    public Basket(int initialCapacity) {
        super(initialCapacity);
    }
    public Basket() {
        super();
    }
    public Basket(Collection<? extends Ball> c) {
        super(c);
    }

    public int totalWeight() {
        int sum = 0;
        for (Ball ball : this)
            sum += ball.getWeight();
        return sum;
    }

    public int countByColor(Color color) {
        Objects.requireNonNull(color);
        int count = 0;
        for (Ball ball : this) {
            if (color.equals(ball.getColor())) {
                count++;
            }
        }
        return count;
    }
}
