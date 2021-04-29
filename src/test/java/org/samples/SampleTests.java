package org.samples;


import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.reporters.QuietReporter;
import org.junit.jupiter.api.Test;
import org.lambda.actions.Action0;
import org.lambda.query.Queryable;

public class SampleTests {
    @Test
    public void testEverything() {
        Board board = new Board();
        for (int i = 0; i <= 8; i++) {
            int y = i * 5 + 2;
            addToBoard(board, i, 2, y, true);
            addToBoard(board, i, 8, y, false);
        }
        String output = "" + board;
        board = board.advanceTurn();
        output += "\n\nAdvance turn\n\n";
        output += board;
        Approvals.verify(output, new Options(QuietReporter.INSTANCE));
    }

    private void addToBoard(Board board, int numberOfNeighbors, int x, int y, boolean isCenterAlive) {
        if (isCenterAlive) {
            board.makeCellAlive(x, y);
        }
        Queryable<Action0> cells = Queryable.as(
                () -> board.makeCellAlive(x, y - 1),
                () -> board.makeCellAlive(x, y + 1),
                () -> board.makeCellAlive(x - 1, y),
                () -> board.makeCellAlive(x + 1, y),

                () -> board.makeCellAlive(x - 1, y - 1),
                () -> board.makeCellAlive(x + 1, y + 1),
                () -> board.makeCellAlive(x + 1, y - 1),
                () -> board.makeCellAlive(x - 1, y + 1)
                );
        for (int i = 0; i < numberOfNeighbors && i < cells.size(); i++) {
            cells.get(i).call();
        }

    }

}
