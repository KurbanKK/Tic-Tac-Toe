package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {
    Scanner scanner = new Scanner(System.in);

    @Override
    void move(Field field) {
        while (true) {
            System.out.print("Enter the coordinates: ");

            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Cell cell = new Cell(x, y);

                if (x > field.size || x < 1 || y > field.size || y < 1) {
                    System.out.println("Coordinates should be from 1 to " + field.size + "!");
                } else if (field.isOccupied(cell)) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    field.set(cell);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
