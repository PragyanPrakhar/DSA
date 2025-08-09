import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) return node;
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionBySize(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if (ultimateParentU == ultimateParentV) return;

        if (size.get(ultimateParentU) > size.get(ultimateParentV)) {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV));
        } else {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV) + size.get(ultimateParentU));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for (int[] arr : connections) {
            if (ds.findUltimateParent(arr[0]) == ds.findUltimateParent(arr[1])) {
                extraEdges++;
            } else {
                ds.unionBySize(arr[0], arr[1]);
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
