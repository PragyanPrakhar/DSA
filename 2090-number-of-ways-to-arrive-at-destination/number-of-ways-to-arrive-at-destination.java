class Pair {
    int node;
    long time;

    Pair(int node, long time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int) (1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] ar : roads) {
            int u = ar[0];
            int v = ar[1];
            int wt = ar[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long time = curr.time;

            for (Pair nei : adj.get(node)) {
                int adjNode = nei.node;
                long edgeTime = nei.time;

                if (time + edgeTime < dist[adjNode]) {
                    dist[adjNode] = time + edgeTime;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, dist[adjNode]));
                } else if (time + edgeTime == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
