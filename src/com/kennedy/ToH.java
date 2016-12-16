package com.kennedy;

/**
 * Created by adixith on 10/30/16.
 */
public class ToH {
    public static int numberOfMoves = 0;
    public void solve(int numberOfDiscs, String start, String aux, String end) {
        numberOfMoves++;
        if(numberOfDiscs == 1) {
            Utils.p("Move from " + start + " to " + end);
        }
        else {
            solve(numberOfDiscs - 1, start, end, aux);
            Utils.p("Move from " + start + " to " + end);
            solve(numberOfDiscs -1, aux, start, end);
        }
    }

    public static void main(String args[]) {
        ToH toH = new ToH();
        for(int discs =1; discs <8; discs++) {
            numberOfMoves = 0;
            toH.solve(discs, "A", "B", "C");
            Utils.p("========================");
            Utils.p("Number of moves = " + numberOfMoves);
            Utils.p("========================");
        }
    }
}
