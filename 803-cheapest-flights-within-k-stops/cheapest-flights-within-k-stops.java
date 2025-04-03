import java.util.*;

class Pair {
    int node;
    int dis;
    int stops;

    Pair(int node, int dis, int stops) {
        this.node = node;
        this.dis = dis;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            adj.get(from).add(new Pair(to, cost, 0));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));
        HashMap<Integer, Integer> bestCost = new HashMap<>();
        bestCost.put(src, 0);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.node, cost = curr.dis, stops = curr.stops;

            if (stops > k) continue;
            for (Pair neighbor : adj.get(node)) {
                int newNode = neighbor.node;
                int newCost = cost + neighbor.dis;

                if (!bestCost.containsKey(newNode) || newCost < bestCost.get(newNode)) {
                    bestCost.put(newNode, newCost);
                    q.add(new Pair(newNode, newCost, stops + 1));
                }
            }
        }

        return bestCost.getOrDefault(dst, -1);
    }
}
