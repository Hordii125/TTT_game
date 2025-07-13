package tic.tac.toe;

public class Statistic {
    WinTie winTie;
    private String lastPlayerWin = ""; // to store the last player who won

    private int tieCount = 0;
    private int xWinCount = 0;
    private int oWinCount = 0;

    public Statistic(WinTie winTie) {
        this.winTie = winTie;
    }

    public String getLastPlayerWin() {
        return lastPlayerWin;
    }

    public void resultCheckForCounters() {
        String result = winTie.getResult(); // Get the result from WinTie
        // Update statistics based on the result
        if (result.equals("tie")) {
            tieCount++;
        } else if (result.equals("x")) {
            xWinCount++;
        } else if (result.equals("o")) {
            oWinCount++;
        }
    }

    public String getLastPlayerWon(){
        String result = winTie.getResult(); // Get the result from WinTie
        if (result.equals("x")) {
            lastPlayerWin = "x";
        } else if (result.equals("o")) {
            lastPlayerWin = "o";
        }
        return lastPlayerWin;
    }

    public void showStatistic() {
        System.out.println("\n\tGame Statistics:");
        System.out.println("\tX Wins: " + xWinCount);
        System.out.println("\tO Wins: " + oWinCount);
        System.out.println("\tTies: " + tieCount);
        System.out.println("\tLast Player Who Won: " + lastPlayerWin);
        System.out.println("\t-------------------------");
    }

    public int getTieCount() {
        return tieCount;
    }

    public int getXWinCount() {
        return xWinCount;
    }

    public int getOWinCount() {
        return oWinCount;
    }

}
