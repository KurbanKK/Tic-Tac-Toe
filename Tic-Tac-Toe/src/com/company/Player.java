package com.company;

public abstract class Player {
    static Player of(String type) {
        switch (type) {
            case "user":
                return new Human();
            case "easy":
                return new EasyAI();
            case "medium":
                return new MediumAI();
            case "hard":
                return new HardAI();
            default:
                return null;
        }
    }

    abstract void move(Field field);
}
