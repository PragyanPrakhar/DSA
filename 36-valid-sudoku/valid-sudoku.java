class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> hs=new HashSet<>();

        //checkig each rows
        for(int i=0;i<board.length;i++){
            HashSet<Character> checkingEachRows=new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                if(checkingEachRows.contains(board[i][j])) return false;
                if(board[i][j]> '9' || board[i][j]<'1') return false;
                checkingEachRows.add(board[i][j]);
            }
        }

        //checking each columns
        for(int i=0;i<board[0].length;i++){
            HashSet<Character> checkingEachCols=new HashSet<>();
            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.') continue;
                if(checkingEachCols.contains(board[j][i])) return false;
                if(board[j][i]> '9' || board[j][i]< '1') return false;
                checkingEachCols.add(board[j][i]);
            }
        }

        //checking each grid of 3 x 3
        for(int row=0;row<board.length;row+=3){
            for(int col=0;col<board[0].length;col+=3){
                HashSet<Character> smallGrid=new HashSet<>();
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                        if(board[i][j]=='.') continue;
                        if(board[i][j]>'9' || board[i][j]<'1') return false;
                        if(smallGrid.contains(board[i][j])) return false;
                        smallGrid.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}