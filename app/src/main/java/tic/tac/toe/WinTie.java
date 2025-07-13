package tic.tac.toe;

public class WinTie {
    private TTTclass game;
    private MakeMove makeMove;

    private String[] number;
    private String wt = "";

    public WinTie(TTTclass game, MakeMove makeMove) {
        this.game = game;
        this.makeMove = makeMove;
        this.number = game.number; // Assuming number is the board state in TTTclass
    }

    public boolean winTie() {
        int[][] winComb = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] combo : winComb) {
            if (number[combo[0]].equals(number[combo[1]]) &&
                number[combo[1]].equals(number[combo[2]])) {
                System.out.println("\n\tRound is over! Player '" + number[combo[0]] + "' won!");
                wt = number[combo[0]];
                return true;
            }
        }

        if (makeMove.getAmountOfFilledCells() == 9) {
            System.out.println("\n\tRound is over! It's a Tie!");
            wt = "tie";
            return true;
        }

        return false;
    }

    

    public String getResult() {
        return wt;
    }

    public void resetResult() {
        wt = "";
    }
}
