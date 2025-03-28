class Node {
    int first;
    int second;
    int third;

    Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Node> q = new LinkedList<Node>();
        int row = mat.length;
        int col = mat[0].length;
        int vis[][] = new int[row][col];
        int dis[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int n = q.peek().first;
            int m = q.peek().second;
            int steps = q.peek().third;
            q.remove();

            dis[n][m] = steps;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int delRow = n + i;
                    int delCol = m + j;
                    if ((i == 0 || j == 0) && (delRow >= 0) && (delRow < row) && (delCol >= 0) && (delCol < col)
                            && (vis[delRow][delCol] == 0)) {
                        vis[delRow][delCol] = 1;
                        q.add(new Node(delRow, delCol, steps + 1));
                    }
                }
            }
        }
        return dis;

    }
}