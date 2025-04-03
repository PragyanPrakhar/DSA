import java.util.*;

class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        int left = 0, right = 1_000_000;
        int ans=right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean[][] vis = new boolean[rows][cols];

            if (isReachable(heights, mid, 0, 0, vis)) {
                ans = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean isReachable(int[][] heights, int maxEffort, int row, int col, boolean[][] vis) {
        int rows = heights.length;
        int cols = heights[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            if (r == rows - 1 && c == cols - 1) return true;

            for (int i = 0; i < 4; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !vis[newRow][newCol]) {
                    int diff = Math.abs(heights[r][c] - heights[newRow][newCol]);
                    if (diff <= maxEffort) {
                        vis[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }

        return false;
    }
}
