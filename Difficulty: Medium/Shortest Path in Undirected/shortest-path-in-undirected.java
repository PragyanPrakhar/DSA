//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// class Pair{
//     int node;
//     int dis;
//     Pair(int node,int dis){
//         this.node=node;
//         this.dis=dis;
//     }
// }
// class Solution {
//     public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
//         int v=adj.size();
//         boolean vis[]=new boolean[v];
//         Arrays.fill(vis,false);
//         int ans[]=new int[v];
//         Queue<Pair> q=new LinkedList<>();
//         vis[src]=true;
//         q.add(new Pair(src,0));
//         while(!q.isEmpty()){
//             int node=q.peek().node;
//             int dis=q.peek().dis;
//             q.remove();
//             ans[node]=dis;
//             for(int it:adj.get(node)){
//                 if(!vis[it]){
//                     q.add(new Pair(it,dis+1));
//                     vis[it]=true;
//                 }
//             }
//         }
//         for(int i=0;i<v;i++){
//             if(!vis[i]){
//                 ans[i]=-1;
//             }
//         }
//         return ans;
//     }
// }

class Pair {
    int node, dis;
    Pair(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int v = adj.size();
        int ans[] = new int[v];
        Arrays.fill(ans, -1); // Mark all nodes as unvisited (-1)
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        ans[src] = 0; // Distance to source is 0

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int dis = q.peek().dis;
            q.poll();
            
            for (int it : adj.get(node)) {
                if (ans[it] == -1) { // If not visited
                    ans[it] = dis + 1;
                    q.add(new Pair(it, dis + 1));
                }
            }
        }
        return ans;
    }
}

