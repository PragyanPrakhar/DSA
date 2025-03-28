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
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        int tm = 0;
        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, 1, 0, -1 };
        int cnt = 0;
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            tm=Math.max(tm,time);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    q.add(new Pair(nRow,nCol,time+1));
                    vis[nRow][nCol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return tm;
    }
}