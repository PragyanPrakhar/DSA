class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        int freshOranges=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                    
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int cnt=0;
        int tm=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int time=q.peek().time;
            tm=Math.max(tm,time);
            q.remove();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int delRow=row+i;
                    int delCol=col+j;
                    if((i==0 || j==0) && delRow>=0 && delRow<grid.length && delCol>=0 && delCol<grid[0].length && !vis[delRow][delCol] && grid[delRow][delCol]==1){
                        q.offer(new Pair(delRow,delCol,time+1));
                        vis[delRow][delCol]=true;
                        // grid[delRow][delCol]=2;
                        cnt++;
                    }
                }
            }
        }
        if(freshOranges!=cnt) return -1;
        return tm;
    }
}