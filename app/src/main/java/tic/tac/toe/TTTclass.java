package tic.tac.toe;

import java.util.Scanner;

public class TTTclass {
    private String[] number = new String[9];
    private int amountOfFilledCells = 0;
    private String wt = "";
    private Scanner input = new Scanner(System.in);

    public TTTclass() {
        for (int i = 0; i < 9; i++) {
            number[i] = String.valueOf(i + 1);
        }
    }

    // Displays the current state of the Tic Tac Toe board
    public void display() {
        System.out.println();
        for (int i = 0; i < 9; i += 3) {
            System.out.printf("%10s%10s%10s\n\n\n", number[i], number[i + 1], number[i + 2]);
        }
    }

    // Methods for players to enter their values
    public void enterValuePlayer1() {
        enterValue("x");
    }

    public void enterValuePlayer2() {
        enterValue("o");
    }

    // Method to handle player input
    private void enterValue(String playerSymbol) {
        boolean valid = false;

        while (!valid) {
            System.out.print("\n\tPlayer '" + playerSymbol + "', enter a value from 1 to 9: ");
            String val = input.next();

            if (val.length() == 1 && Character.isDigit(val.charAt(0))) {
                int idx = Integer.parseInt(val);
                if (idx >= 1 && idx <= 9 && !number[idx - 1].equals("x") && !number[idx - 1].equals("o")) {
                    number[idx - 1] = playerSymbol;
                    valid = true;
                } else {
                    System.out.println("\n\tThis cell is occupied or invalid, try again.");
                }
            } else {
                System.out.println("\n\tInvalid input, please enter a number from 1 to 9.");
            }
        }
        amountOfFilledCells++;
    }

    // Checks for a win or tie condition
    public boolean winTie() {
        int[][] winComb = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] combo : winComb) {
            if (number[combo[0]].equals(number[combo[1]]) && number[combo[1]].equals(number[combo[2]])) {
                System.out.println("\n\tGame Over! Player '" + number[combo[0]] + "' won.");
                System.out.println("\n\tWinning combination: " + combo[0] + ", " + combo[1] + ", " + combo[2]);
                wt = number[combo[0]];
                return true;
            }
        }

        if (amountOfFilledCells == 9) {
            System.out.println("\n\tGame Over! It's a Tie.");
            return true;
        }

        return false;
    }

    // Provides a hint for the next available moves
    public void smartHint() {
        System.out.print("\n\tAvailable moves: ");
        for (int i = 0; i < 9; i++) {
            if (!number[i].equals("x") && !number[i].equals("o")) {
                System.out.print(number[i] + " ");
            }
        }
        System.out.println("\n\n\n");
    }
}
