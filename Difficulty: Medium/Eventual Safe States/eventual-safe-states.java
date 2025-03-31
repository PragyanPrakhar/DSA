//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean pathVis[]=new boolean[V];
        boolean safeNodes[]=new boolean[V];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(dfs(i,pathVis,safeNodes,V,adj)){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean dfs(int node,boolean pathVis[],boolean safeNodes[],int V,List<List<Integer>> adj){
        if(safeNodes[node]) return true;
        pathVis[node]=true;
        for(int it:adj.get(node)){
            if(!pathVis[it]){
                if(!dfs(it,pathVis,safeNodes,V,adj)){
                    return false;
                }
            }
            else if(pathVis[it]){
                return false;
            }
        }
        pathVis[node]=false;
        safeNodes[node]=true;
        return true;
    }
}
