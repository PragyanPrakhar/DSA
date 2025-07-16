import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0 -> unvisited, 1 -> color1, -1 -> color2
        Arrays.fill(colors, 0); 

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // Start BFS for each component
                if (!bfs(graph, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 1; // Start with color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (colors[neighbor] == 0) { // Unvisited, assign opposite color
                    colors[neighbor] = -colors[node];
                    queue.offer(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false; // Conflict found
                }
            }
        }
        return true;
    }
}
