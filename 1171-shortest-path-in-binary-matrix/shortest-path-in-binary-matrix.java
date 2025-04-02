class Pair {
    int row;
    int col;
    int dis;

    Pair(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0) return -1;
        if(grid.length==1 && grid[0].length==1 && grid[0][0]==0) return 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        vis[0][0]=true;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean reached=false;
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dis;
            q.remove();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int delRow = row + i;
                    int delCol = col + j;
                    if (delRow == grid.length - 1 && delCol == grid[0].length - 1) {
                        reached=true;
                        ans.add(dis + 1);
                        break;
                    }
                    if (delRow >= 0 && delRow < grid.length && delCol >= 0
                            && delCol < grid[0].length  && !vis[delRow][delCol] && grid[delRow][delCol] == 0) {
                        vis[delRow][delCol] = true;
                        q.add(new Pair(delRow, delCol, dis + 1));
                    }
                }
            }
        }
        if(!reached) return -1;
        int res = Integer.MAX_VALUE;
        for (int i : ans) {
            res = Math.min(res, i);
        }
        return res;
    }
}