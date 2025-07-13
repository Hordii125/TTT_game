package tic.tac.toe;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WinTieTest {
    private final TTTclass game = new TTTclass();
    private final MakeMove makeMove = new MakeMove(game, game.number);
    private final WinTie winTie = new WinTie(game, makeMove);
    private final String[] initialBoard = game.number.clone();

    @Test
    public void testWinCondition() {
        // Set up a winning condition for player 'X'
        game.number[0] = "X";
        game.number[1] = "X";
        game.number[2] = "X";

        assertEquals(true, winTie.winTie());
        assertEquals("X", winTie.getResult());
    }

    @Test
    public void testTieCondition() {
        // Fill the board to create a tie condition
        game.number[0] = "X";
        game.number[1] = "O";
        game.number[2] = "X";
        game.number[3] = "O";
        game.number[4] = "X";
        game.number[5] = "O";
        game.number[6] = "O";
        game.number[7] = "X";
        game.number[8] = "O";

        makeMove.setAmountOfFilledCells(9); // Set filled cells to 9

        assertEquals(true, winTie.winTie());
        assertEquals("tie", winTie.getResult());
    }
}
