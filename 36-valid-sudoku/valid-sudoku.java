class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> bigRow=new HashSet<>();
        HashSet<Character> bigCol=new HashSet<>();

        // Checking each mini square
        for(int i=0;i<board.length;i+=3){
            for(int j=0;j<board[0].length;j+=3){
                HashSet<Character> miniSquare=new HashSet<>();
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

        return true;


    }
}