package tic.tac.toe;

public class Display {

    private TTTclass game;

    public Display(TTTclass game) {
        this.game = game;
    }

    public String DisplayBoard(String[] number) {
        StringBuilder board = new StringBuilder("\n");
        for (int i = 0; i < 9; i += 3) {
            board.append(String.format("%10s%10s%10s\n\n\n", number[i], number[i + 1], number[i + 2]));
        }
        return board.toString();
    }
}
