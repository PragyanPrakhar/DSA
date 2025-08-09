import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) return node;
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent); // path compression
        return ultimateParent;
    }

    public void unionByRank(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        if (pu == pv) return;

        if (rank.get(pu) > rank.get(pv)) {
            parent.set(pv, pu);
        } else if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        if (pu == pv) return;

        if (size.get(pu) > size.get(pv)) {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        } else {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        }
    }
}

class Pair {
    int src;
    int dest;
    int weight;
    Pair(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        // Step 1: Store edges in list
        List<Pair> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            edgeList.add(new Pair(e[0], e[1], e[2]));
        }

        // Step 2: Sort edges by weight
        edgeList.sort(Comparator.comparingInt(a -> a.weight));

        // Step 3: Kruskal's Algorithm
        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;

        for (Pair edge : edgeList) {
            if (ds.findUltimateParent(edge.src) != ds.findUltimateParent(edge.dest)) {
                mstWeight += edge.weight;
                ds.unionByRank(edge.src, edge.dest); // or unionBySize
            }
        }

        return mstWeight;
    }
}
