package algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char r = board[i][j];
                char c = board[j][i];

                if ((r != '.' && !row.add(r)) || (c != '.' && !col.add(c)))
                    return false;
            }
        }

        for (int i = 0 ; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!isCheckBlock(board, i, j))
                    return false;
            }
        }
        return true;
    }

    public static boolean isCheckBlock(char[][] board, int row, int col) {
        Set<Character> square = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.' && !square.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
}
