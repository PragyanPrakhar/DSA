class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int outdegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
        }
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        boolean safeNodes[]=new boolean[n];

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, vis, pathVis,safeNodes)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int node, int[][] graph, boolean vis[], boolean pathVis[], boolean safeNodes[]) {
        if (safeNodes[node])
            return true;
        // vis[node] = true;
        pathVis[node] = true;
        for (int neighbor : graph[node]) {
            if (!pathVis[neighbor]) {
                if (!dfs(neighbor, graph, vis, pathVis, safeNodes)) {
                    return false;
                }
            } else if (pathVis[neighbor] == true) {
                return false;
            }
        }
        pathVis[node] = false;
        safeNodes[node] = true;
        return true;
    }
}
