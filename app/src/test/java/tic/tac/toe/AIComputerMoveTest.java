package tic.tac.toe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AIComputerMoveTest {
    @Test
    public void testMakeAIMove() {
        TTTclass game = new TTTclass();
        MakeMove makeMove = new MakeMove(game, game.number);
        SmartHint smartHint = new SmartHint(game);
        AIComputerMove aiComputerMove = new AIComputerMove(game, game.number, makeMove, smartHint);
        String aiPlayer = "o";
        game.number[0] = "x"; // Simulate player 'x' has made a move
        game.number[1] = "2"; // Simulate cell 2 is available
        game.number[2] = "3"; // Simulate cell 3 is available
        game.number[3] = "4"; // Simulate cell 4 is available
        game.number[4] = "5"; // Simulate cell 5 is available
        game.number[5] = "6"; // Simulate cell 6 is available
        game.number[6] = "7"; // Simulate cell 7 is available
        game.number[7] = "8"; // Simulate cell 8 is available
        game.number[8] = "9"; // Simulate cell 9 is available

        boolean moveMade = aiComputerMove.makeAIMove(aiPlayer);
        assertEquals(true, moveMade);
        assertEquals("o", game.number[2]); // AI should place in the first available cell (cell 2, index 1)
        assertEquals(1, makeMove.getAmountOfFilledCells()); // Check if filled count increased

    }

    @Test
    public void testMakeAIMoveWithWinningMove() {
        TTTclass game = new TTTclass();
        MakeMove makeMove = new MakeMove(game, game.number);
        SmartHint smartHint = new SmartHint(game);
        AIComputerMove aiComputerMove = new AIComputerMove(game, game.number, makeMove, smartHint);
        String aiPlayer = "o";
        game.number[0] = "x"; // Simulate player 'x' has made a move
        game.number[1] = "x"; // Simulate player 'x' has made a move
        game.number[2] = "3"; // Simulate cell 3 is available
        game.number[3] = "4"; // Simulate cell          
        game.number[4] = "5"; // Simulate cell 5 is available
        game.number[5] = "6"; // Simulate cell 6 is available
        game.number[6] = "7"; // Simulate cell 7 is available
        game.number[7] = "8"; // Simulate cell 8 is available
        game.number[8] = "9"; // Simulate cell 9 is available

        boolean moveMade = aiComputerMove.makeAIMove(aiPlayer);
        assertEquals(true, moveMade);
        assertEquals("o", game.number[2]); // AI should place in the winning cell
        assertEquals(1, makeMove.getAmountOfFilledCells()); // Check if filled count increased
    }

    @Test
    public void testMakeAIMoveWithBlockingMove() {
        TTTclass game = new TTTclass();
        MakeMove makeMove = new MakeMove(game, game.number);
        SmartHint smartHint = new SmartHint(game);
        AIComputerMove aiComputerMove = new AIComputerMove(game, game.number, makeMove, smartHint);
        String aiPlayer = "o";
        game.number[0] = "x"; // Simulate player 'x' has made a move
        game.number[1] = "2"; // Simulate cell 2 is available
        game.number[2] = "3"; // Simulate cell 3 is available
        game.number[3] = "4"; // Simulate cell 4 is available
        game.number[4] = "5"; // Simulate cell 5 is available
        game.number[5] = "6"; // Simulate cell 6 is available
        game.number[6] = "x"; // Simulate player 'x' has made a move
        game.number[7] = "8"; // Simulate cell 8 is available
        game.number[8] = "9"; // Simulate cell 9 is available   

        boolean moveMade = aiComputerMove.makeAIMove(aiPlayer);
        assertEquals(true, moveMade);
        assertEquals("o", game.number[3]); // AI should place in the blocking cell
        assertEquals(1, makeMove.getAmountOfFilledCells()); // Check if filled count increased
    }
}
