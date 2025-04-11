class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltimateParent(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionBySize(int u, int v) {
        int upU = findUltimateParent(u);
        int upV = findUltimateParent(v);
        if (upU == upV) return;

        if (size.get(upU) > size.get(upV)) {
            parent.set(upV, upU);
            size.set(upU, size.get(upU) + size.get(upV));
        } else {
            parent.set(upU, upV);
            size.set(upV, size.get(upV) + size.get(upU));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for (int[] conn : connections) {
            if (ds.findUltimateParent(conn[0]) == ds.findUltimateParent(conn[1])) {
                extraEdges++;
            } else {
                ds.unionBySize(conn[0], conn[1]);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUltimateParent(i) == i) {
                components++;
            }
        }

        return (extraEdges >= components - 1) ? components - 1 : -1;
    }
}
