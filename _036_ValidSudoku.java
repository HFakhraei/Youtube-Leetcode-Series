import java.util.ArrayList;
import java.util.List;
public class _036_ValidSudoku {
    public static void main(String[] args) {
        char[][] board = 
{{'8','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        boolean result = isValidSudoku(board);
        System.out.println(result);
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRowUniqueness(board, i))
                return false;
            if (!checkColumnUniqueness(board, i))
                return false;
            if (!checkSquereUniqueness(board, i))
                return false;
        }
        return true;
    }

    private static boolean checkRowUniqueness(char[][] board, int i) {
        char[] row = board[i];
        return checkUniqueness(row);
    }

    private static boolean checkColumnUniqueness(char[][] board, int i) {
        char[] column = new char[9];
        for(int j = 0; j < 9; j++) {
            column[j] = board[j][i];
        }
        return checkUniqueness(column);
    }

    private static boolean checkSquereUniqueness(char[][] board, int i) {
        char[] column = new char[9];
        int xStart = 0;
        int yStart = 0;

        switch (i) {
            case 0:
                xStart = 0; yStart = 0; break;
            case 1:
                xStart = 0; yStart = 3; break;
            case 2:
                xStart = 0; yStart = 6; break;
            case 3:
                xStart = 3; yStart = 0; break;
            case 4:
                xStart = 3; yStart = 3; break;
            case 5:
                xStart = 3; yStart = 6; break;
            case 6:
                xStart = 6; yStart = 0; break;
            case 7:
                xStart = 6; yStart = 3; break;
            case 8:
                xStart = 6; yStart = 6; break;
        }
        int n = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                column[n++] = board[j + xStart][k + yStart];
            }
        }
        return checkUniqueness(column);
    }

    private static boolean checkUniqueness(char[] arr) {
        List<Character> list = new ArrayList<>();
        for(char chr: arr) {
            if ('.' == chr)
                continue;
            if (list.contains(chr))
                return false;
            list.add(chr);
        }
        return true;
    }
}

