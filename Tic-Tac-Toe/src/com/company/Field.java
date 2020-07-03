package com.company;

public class Field {
    static int size = 3;
    private char[][] cells = new char[size][size];
    private char winner = '\0';
    boolean xIsNext = true;
    private int numberOfEmptyCells = size*size;

    public Field() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = '_';
            }
        }
    }

    void print() {
        System.out.println("---------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    boolean isOccupied(Cell cell) {
        int row = size - cell.getY();
        int column = cell.getX() - 1;

        return cells[row][column] != '_';
    }

    void set(Cell cell) {
        if (isOccupied(cell)) {
            return;
        }

        int row = size - cell.getY();
        int column = cell.getX() - 1;

        cells[row][column] = xIsNext ? 'X' : 'O';
        xIsNext = !xIsNext;
        numberOfEmptyCells--;

        winner = checkWinner();
    }

    private char checkWinner() {
        if (checkRows('X') || checkColumns('X') || checkDiagonals('X')) {
            return 'X';
        } else if (checkRows('O') || checkColumns('O') || checkDiagonals('O')) {
            return 'O';
        } else if (numberOfEmptyCells == 0) {
            return '_';
        }
        return '\0';
    }

    private boolean checkRows(char ch) {
        for (int k = 0; k < size; k++) {
            if (cells[k][0] == ch && cells[k][1] == ch && cells[k][2] == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char ch) {
        for (int k = 0; k < size; k++) {
            if (cells[0][k] == ch && cells[1][k] == ch && cells[2][k] == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char ch) {
        return cells[0][0] == ch && cells[1][1] == ch && cells[2][2] == ch ||
                cells[0][2] == ch && cells[1][1] == ch && cells[2][0] == ch;
    }


    boolean gameOver() {
        return winner != '\0';
    }

    char getWinner() {
        return winner;
    }


}
