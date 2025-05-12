import org.junit.Test;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void testPrintBoard() {
        boolean[][] board = new boolean[4][4];
        board[0][1] = true;
        board[1][0] = true;
        board[2][3] = true;
        board[3][1] = true;

        Logic.printBoard(board);
    }

    @Test
    public void testCheckBoardEmpty() {
        boolean[][] board = new boolean[4][4];
        assertTrue(Logic.checkBoard(0, 0, board));
    }

    @Test
    public void testCheckBoardRowConflict() {
        boolean[][] board = new boolean[4][4];
        board[0][3] = true;
        assertFalse(Logic.checkBoard(0, 0, board));
    }

    @Test
    public void testCheckBoardColumnConflict() {
        boolean[][] board = new boolean[4][4];
        board[3][0] = true;
        assertFalse(Logic.checkBoard(0, 0, board));
    }

    @Test
    public void testCheckBoardDiagonalConflict() {
        boolean[][] board = new boolean[4][4];
        board[2][2] = true;
        assertFalse(Logic.checkBoard(0, 0, board));
    }

    @Test
    public void testPlaceQueensRecursive() {
        boolean[][] board = new boolean[4][4];
        Logic.solutionsCounter = 0;

        Logic.placeQueensRecursive(0, board);

        assertEquals(2, Logic.solutionsCounter);
    }
}