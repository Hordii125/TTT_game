package tic.tac.toe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.checkerframework.checker.units.qual.g;
import org.junit.jupiter.api.Test;

public class StatisticTest {
    @Test
    public void testResultCheckForCounters() {
        TTTclass game = new TTTclass();
        MakeMove makeMove = new MakeMove(game, game.number);
        WinTie winTie = new WinTie(game, makeMove);
        Statistic statistic = new Statistic(winTie);
        winTie.setResult("x");
        statistic.resultCheckForCounters();
        assertEquals(0, statistic.getTieCount());
        assertEquals(1, statistic.getXWinCount());
        assertEquals(0, statistic.getOWinCount());
        winTie.setResult("o");
        statistic.resultCheckForCounters();
        assertEquals(0, statistic.getTieCount());
        assertEquals(1, statistic.getXWinCount());
        assertEquals(1, statistic.getOWinCount());
        winTie.setResult("tie");
        statistic.resultCheckForCounters();
        assertEquals(1, statistic.getTieCount());
        assertEquals(1, statistic.getXWinCount());
        assertEquals(1, statistic.getOWinCount());

        statistic.showStatistic();
    }

    
}
