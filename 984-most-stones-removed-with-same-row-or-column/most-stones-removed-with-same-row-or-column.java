class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int totalRemovable = 0;
        boolean vis[] = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] cnt = new int[]{0}; // Wrapper for count
                dfs(stones, n, vis, i, cnt);
                totalRemovable += cnt[0] - 1;
            }
        }
        return totalRemovable;
    }

    private void dfs(int[][] stones, int n, boolean[] vis, int node, int[] cnt) {
        vis[node] = true;
        cnt[0]++;
        for (int i = 0; i < n; i++) {
            if (!vis[i] && (stones[node][0] == stones[i][0] || stones[node][1] == stones[i][1])) {
                dfs(stones, n, vis, i, cnt);
            }
        }
    }
}
