package org.samples;

import org.lambda.utils.Grid;

import java.util.HashSet;
import java.util.Set;

public class Board {
    Set<AliveCell> aliveCells = new HashSet<>();
    public Board advanceTurn() {
        return new Board();
    }

    @Override
    public String toString() {
        return Grid.print(15, 50, (x,y) -> isALive(x, y) ? "X" :"_");
    }

    private boolean isALive(Integer x, Integer y) {
        return aliveCells.contains(new AliveCell(x, y));
    }

    public void makeCellAlive(int x, int y) {
        aliveCells.add(new AliveCell(x,y));
    }
}
