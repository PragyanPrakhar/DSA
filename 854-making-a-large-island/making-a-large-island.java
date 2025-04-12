class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        if (pu == pv) return;

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}

class Pair {
    int row, col;
    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        DisjointSet ds = new DisjointSet(rows * cols);
        boolean[][] vis = new boolean[rows][cols];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int node = i * cols + j;
                    bfs(node, i, j, vis, grid, q, ds);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> uniqueParents = new HashSet<>();
                    int totalSize = 1;

                    for (int delRow = -1; delRow <= 1; delRow++) {
                        for (int delCol = -1; delCol <= 1; delCol++) {
                            if (Math.abs(delRow) + Math.abs(delCol) != 1) continue;

                            int newRow = i + delRow;
                            int newCol = j + delCol;

                            if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols
                                    && grid[newRow][newCol] == 1) {
                                int parent = ds.findUPar(newRow * cols + newCol);
                                if (!uniqueParents.contains(parent)) {
                                    totalSize += ds.size.get(parent);
                                    uniqueParents.add(parent);
                                }
                            }
                        }
                    }
                    ans = Math.max(ans, totalSize);
                }
            }
        }

        for (int i = 0; i < rows * cols; i++) {
            ans = Math.max(ans, ds.size.get(ds.findUPar(i)));
        }

        return ans;
    }

    private void bfs(int node, int row, int col, boolean[][] vis, int[][] grid, Queue<Pair> q, DisjointSet ds) {
        int cols = grid[0].length;
        vis[row][col] = true;
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int roww = curr.row;
            int coll = curr.col;

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    if (Math.abs(delRow) + Math.abs(delCol) != 1) continue;

                    int newRow = roww + delRow;
                    int newCol = coll + delCol;

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length &&
                            grid[newRow][newCol] == 1 && !vis[newRow][newCol]) {

                        vis[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                        int newNode = newRow * cols + newCol;
                        ds.unionBySize(node, newNode);
                    }
                }
            }
        }
    }
}
