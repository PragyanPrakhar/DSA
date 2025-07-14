class Node {
    int row;
    int col;
    int time;

    Node(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalFreshOranges = 0;
        int vis[][] = new int[rows][cols];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==2){
                    q.add(new Node(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }

                if(grid[i][j]==1){
                    totalFreshOranges++;
                }
            }
        }
        // boolean vis[][] = new boolean[rows][cols];
        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, 0, -1 };
        int tm=0;
        int cnt=0;
        while (!q.isEmpty()) {
            Node node = q.peek();
            int row = node.row;
            int col = node.col;
            int time = node.time;
            tm=Math.max(time,tm);
            q.remove();
            // vis[row][col] = true;
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                if(nRow>=0 && nCol>=0 && nRow<rows && nCol<cols && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                    vis[nRow][nCol]=2;
                    q.offer(new Node(nRow,nCol,time+1));
                    cnt++;
                }
            }
        }
        if(cnt != totalFreshOranges) return -1;
        return tm;

    }
}