class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting (in stack), 2 = safe
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] == 1) return false; // Found cycle
        if (state[node] == 2) return true;  // Already marked safe

        state[node] = 1; // Mark node as being visited (in recursion stack)

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, state)) {
                return false; // If a cycle is found, mark this node unsafe
            }
        }

        state[node] = 2; // Mark node as safe
        return true;
    }
}
