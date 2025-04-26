package Recursion.Hard;

public class wordeSearch {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Traverse every cell as a potential starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static  boolean helper(char[][] board, int row, int col, String word, int index) {
        // Base case: If the entire word is found
        if (index == word.length()) {
            return true;
        }

        // Check bounds and if the current cell matches the word's character
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by modifying it temporarily
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore in all 4 directions
        boolean found = helper(board, row + 1, col, word, index + 1) || // Down
                        helper(board, row - 1, col, word, index + 1) || // Up
                        helper(board, row, col + 1, word, index + 1) || // Right
                        helper(board, row, col - 1, word, index + 1);   // Left

        // Restore the cell's original value after backtracking
        board[row][col] = temp;

        return found;
    }
}
