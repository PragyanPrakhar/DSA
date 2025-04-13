class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(0,0,grid[0][0]));
        boolean vis[][]=new boolean[rows][cols];
        // vis[0][0]=true;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;
            if(row==rows-1 && col==cols-1){
                return time;
            }
            vis[row][col]=true;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int delRow=row+i;
                    int delCol=col+j;
                    if((i==0 || j==0) && delRow>=0 && delRow<rows && delCol>=0 && delCol<cols && !vis[delRow][delCol]){
                        pq.add(new Pair(delRow,delCol,Math.max(time,grid[delRow][delCol])));
                    }
                }
            }
        }
        return 0;
    }
}