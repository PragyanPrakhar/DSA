class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> completeRow = new HashSet<>();
        HashSet<Character> completeCol = new HashSet<>();

        for(int i=0;i<board.length;i=i+3){
            for(int j=0;j<board[0].length;j=j+3){
                HashSet<Character> miniSquare = new HashSet<>();
                for(int row=i;row<i+3;row++){
                    for(int col=j;col<j+3;col++){
                        if(board[row][col]=='.') continue;
                        if(board[row][col]>'9' || board[row][col]<'1') return false;
                        if(miniSquare.contains(board[row][col])) return false;
                        miniSquare.add(board[row][col]);
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++){
            HashSet<Character> singleRow = new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                if(singleRow.contains(board[i][j])) return false;
                if(board[i][j] > '9' || board[i][j]<'1') return false;
                singleRow.add(board[i][j]);
            }
        }

        for(int i=0;i<board[0].length;i++){
            HashSet<Character> singleColumn = new HashSet<>();
            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.') continue;
                if(singleColumn.contains(board[j][i])) return false;
                if(board[j][i]>'9' || board[j][i]<'1') return false;
                singleColumn.add(board[j][i]);
            }
        }
        return true;
    }
}