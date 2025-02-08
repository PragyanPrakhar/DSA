class Solution {
    public void solveSudoku(char[][] board) {
        solving(0, 0, board);
    }

    private boolean canPlace(char x, int row, int col, char[][] board) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == x) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == x) return false;
        }

        // Check 3×3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == x) return false;
            }
        }

        return true;
    }

    private boolean solving(int row, int col, char[][] board) {
        // If we've reached the end of the board, return true (solved)
        if (row == 9) return true;

        // Move to the next row if we reach the end of a column
        if (col == 9) return solving(row + 1, 0, board);

        // If cell is already filled, move to the next column
        if (board[row][col] != '.') {
            return solving(row, col + 1, board);
        }

        // Try placing numbers 1-9
        for (char num = '1'; num <= '9'; num++) {
            if (canPlace(num, row, col, board)) {
                board[row][col] = num;

                // Recursively solve the next cell
                if (solving(row, col + 1, board)) return true;

                // Backtrack if placing `num` didn't lead to a solution
                board[row][col] = '.';
            }
        }

        return false; // No valid number found, trigger backtracking
    }
}
