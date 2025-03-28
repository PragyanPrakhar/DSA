//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjM=new ArrayList<>();
        int numVertices=adj.size();
        for(int i=0;i<V;i++){
            adjM.add(new ArrayList<>());
        }
        int p=0;
        for(ArrayList<Integer> arr:adj){
            for(int i=0;i<arr.size();i++){
                if(i!=p && arr.get(i)==1){
                    adjM.get(p).add(i);
                }
            }
            p++;
        }
        boolean vis[]=new boolean[V+1];
        int count=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(i,adjM,vis);
            }
        }
        return count;
    }
    private static void dfs(int source,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[source]=true;
        for(int i:adj.get(source)){
            if(vis[i]==false){
                dfs(i,adj,vis);
            }
        }
    }
};