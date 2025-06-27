package tic.tac.toe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TTTtest {
    private final TTTclass game = new TTTclass();

    @Test
    public void testInitialStateHasNoWinner() {
        assertEquals("", game.getResult());
    }

    @Test
    public void testValidMove() {
        boolean moved = game.makeMove("x", 1);
        assertTrue(moved);
    }

    @Test
    public void testInvalidMoveAlreadyTaken() {
        game.makeMove("x", 1);
        boolean moved = game.makeMove("o", 1);
        assertFalse(moved);
    }

    @Test
    public void testWinningMoveX() {
        game.makeMove("x", 1);
        game.makeMove("x", 2);
        game.makeMove("x", 3);
        game.winTie();
        assertEquals("x", game.getResult());
    }

    @Test
    public void testTieGame() {
        game.makeMove("x", 1);
        game.makeMove("o", 2);
        game.makeMove("x", 3);
        game.makeMove("x", 4);
        game.makeMove("o", 5);
        game.makeMove("x", 6);
        game.makeMove("o", 7);
        game.makeMove("x", 8);
        game.makeMove("o", 9);
        game.winTie();
        assertEquals("tie", game.getResult());
    }
}
