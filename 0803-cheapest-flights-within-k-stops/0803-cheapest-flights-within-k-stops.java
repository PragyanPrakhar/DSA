class Pair {
    int node;
    int steps;
    int cost;

    Pair(int node, int steps, int cost) {
        this.node = node;
        this.steps = steps;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] arr : flights) {
            adj.get(arr[0]).add(new Pair(arr[1], 0, arr[2]));
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        int cheapestCost = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.node;
            int steps = current.steps;
            int cost = current.cost;

            if (steps > k + 1) continue; 

            if (node == dst) {
                cheapestCost = Math.min(cheapestCost, cost);
                continue;
            }

            for (Pair neighbor : adj.get(node)) {
                int newCost = cost + neighbor.cost;
                
                if (newCost < minCost[neighbor.node]) {
                    minCost[neighbor.node] = newCost;
                    q.add(new Pair(neighbor.node, steps + 1, newCost));
                }
            }
        }

        return cheapestCost == Integer.MAX_VALUE ? -1 : cheapestCost;
    }
}
