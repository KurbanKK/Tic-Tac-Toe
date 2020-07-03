package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printHelp();

            System.out.print("Input command: ");
            String command = scanner.nextLine();
            if ("exit".equals(command)) {
                break;
            }

            String[] arguments = command.split("\\s+");
            if (arguments.length != 3 || !"start".equals(arguments[0])) {
                System.out.println("Bad parameters!");
                continue;
            }

            Player[] players = new Player[2];
            players[0] = Player.of(arguments[1]);
            players[1] = Player.of(arguments[2]);

            if (players[0] == null || players[1] == null) {
                System.out.println("Bad parameters!");
                continue;
            }

            runGame(players[0], players[1]);

            System.out.println();
        }
    }

    static void printHelp() {
        System.out.println("The command \"start\" take two parameters: " +
                "who will play ‘X’ and who will play ‘O’.\n" +
                "The parameter \"user\" to play as a human and " +
                "\"easy\"/\"medium\"/\"hard\" to play as an easy/medium/hard level AI\n" +
                "The command \"exit\" simply terminate the program");
    }

    static void runGame(Player xPlayer, Player oPlayer) {
        Field field = new Field();
        field.print();

        while (!field.gameOver()) {
            if (field.xIsNext) {
                xPlayer.move(field);
            } else {
                oPlayer.move(field);
            }
            field.print();
        }

        char winner = field.getWinner();
        switch (winner) {
            case 'X':
            case 'O':
                System.out.println(winner + " wins");
                break;
            case '_':
                System.out.println("Draw");
        }
    }

}
