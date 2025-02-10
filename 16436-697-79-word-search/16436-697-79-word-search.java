class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, i, j, word))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int row, int col, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] != word.charAt(0))
            return false;
        if (len == 1)
            return true;
        char temp = board[row][col];
        board[row][col] = '*';
        boolean found = search(board, row + 1, col, word.substring(1)) ||
                search(board, row - 1, col, word.substring(1)) ||
                search(board, row, col + 1, word.substring(1)) ||
                search(board, row, col - 1, word.substring(1));
        board[row][col] = temp;

        return found;
    }
}