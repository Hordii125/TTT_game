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

    @Test
    public void testNoWinOrTieCondition() {
        // Set up a board with no win or tie condition
        game.number[0] = "X";
        game.number[1] = "O";
        game.number[2] = "3";
        game.number[3] = "4";
        game.number[4] = "5";
        game.number[5] = "6";
        game.number[6] = "7";
        game.number[7] = "8";
        game.number[8] = "9";       

        makeMove.setAmountOfFilledCells(2); // Set filled cells to 2
        assertEquals(false, winTie.winTie());
        assertEquals("", winTie.getResult());
    }

    @Test
    public void testResetResult() {
        // Set a result and then reset it
        winTie.setResult("X");
        assertEquals("X", winTie.getResult());
        winTie.resetResult();
        assertEquals("", winTie.getResult());
    }
}
