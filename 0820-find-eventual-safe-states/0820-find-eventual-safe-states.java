class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int indegree[] = new int[graph.length];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int ne : graph[i]) {
                adj.get(ne).add(i);
                indegree[i]++;
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;

    }
}