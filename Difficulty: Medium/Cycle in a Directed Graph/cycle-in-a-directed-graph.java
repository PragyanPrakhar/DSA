//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[]=new int[adj.size()];
        int pathVis[]=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis)) return true;
            }
            
        }
        return false;
    }
    private boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int vis[],int pathVis[]){
        vis[node]=1;
        pathVis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,adj,vis,pathVis)) return true;
            }
            else if(pathVis[it]==1) return true;
        }
        pathVis[node]=0;
        return false;
    }
}