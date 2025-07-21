class Pair{
    int row;
    int col;
    int steps;
    Pair(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,1));
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        vis[0][0]=true;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int steps=q.peek().steps;
            if(row==grid.length-1 && col==grid[0].length-1) return steps;
            q.remove();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int delRow=row+i;
                    int delCol=col+j;
                    if(delRow>=0 && delRow<grid.length && delCol>=0 && delCol<grid[0].length && !vis[delRow][delCol] && grid[delRow][delCol]==0){
                        q.add(new Pair(delRow,delCol,steps+1));
                        vis[delRow][delCol]=true;
                    }

                }
            }
        }
        return -1;
    }
}