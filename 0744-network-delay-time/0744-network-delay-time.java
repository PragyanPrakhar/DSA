class Pair {
    int node;
    int time;

    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ar : times) {
            int src = ar[0];
            int dest = ar[1];
            int tm = ar[2];
            adj.get(src).add(new Pair(dest, tm));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.node;
            int time = current.time;

            for (Pair p : adj.get(node)) {
                int nextNode = p.node;
                int edgeWeight = p.time;

                if (time + edgeWeight < dist[nextNode]) {
                    dist[nextNode] = time + edgeWeight;
                    q.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
