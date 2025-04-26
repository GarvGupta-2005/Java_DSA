package Recursion.Hard;

public class sudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board); // Call the helper function to solve the board
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') { //finding the first empty cell
                    // Try placing each number from '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            // Recursively solve the rest of the board
                            if (solve(board)) {
                                return true;
                            } else {
                                // Backtrack if the current choice doesn't lead to a solution
                                board[i][j] = '.';
                            }
                        }
                    }
                    // If no valid number can be placed, return false
                    return false;
                }
            }
        }
        // If the board is completely filled, return true
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check if the number already exists in the current row or column
            if (board[i][col] == c || board[row][i] == c) {
                return false;
            }

            // Check if the number already exists in the current 3x3 sub-grid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {  //The most importatnt and tricky condition to check is the 3x3 sub-grid
                return false;   //Here we divide the row and column by 3 to get the starting index of the 3x3 sub-grid and then we add i/3 to get the current row and i%3 to get the current column
            }
        }
        return true;
    }
}
