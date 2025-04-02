//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Pair {
    int v;
    int w;

    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Solution {
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int vis[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        int dist[] = new int[N];
        for(int i=0;i<N;i++)
        {
            dist[i]=(int)(1e9);
        }
        dist[0] = 0; 
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Pair p : adj.get(node)) { 
                int v = p.v;
                int wt = p.w;
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        for(int i=0;i<dist.length;i++)
        {
            if(dist[i]==(int)(1e9))
            {
                dist[i]=-1;
            }
        }
        return dist;
    }

    private void dfs(int V, int vis[], Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        vis[V] = 1;
        for (Pair p : adj.get(V)) {
            int v = p.v;
            if (vis[v] == 0) {
                dfs(v, vis, st, adj);
            }
        }
        st.add(V);
    }
}