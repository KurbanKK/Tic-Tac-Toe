package com.company;

import java.util.Random;

public class EasyAI extends Player {
    Random random = new Random();

    @Override
    void move(Field field) {
        System.out.println("Making move level \"easy\"");

        int x, y;
        do {
            x = random.nextInt(3) + 1;
            y = random.nextInt(3) + 1;
        } while (field.isOccupied(new Cell(x, y)));

        field.set(new Cell(x, y));
    }
}
