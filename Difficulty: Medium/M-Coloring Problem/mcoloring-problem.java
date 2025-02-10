//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private static boolean isSafe(List<int[]> edges,int[] color,int i,int node)
    {
        for(int edge[]:edges){
            if((edge[0]==node && color[edge[1]]==i) || (edge[1]==node && color[edge[0]]==i))
            {
                return false;
            }
        } 
        return true;
    }
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        int n=edges.size();
        int node=0;
        int color[]=new int[v];
        if(solve(v,edges,m,node,color)==true)
        {
            return true;
        }
        return false;
    }
    private boolean solve(int v,List<int[]> edges,int m,int node,int color[])
    {
        if(node==v)
        {
            return true;
        }
        for(int i=1;i<=m;i++)
        {
            if(isSafe(edges,color,i,node))
            {
                color[node]=i;
                if(solve(v,edges,m,node+1,color)==true)
                {
                    return true;
                }
                color[node]=0;
            }
        }
        return false;
    }
    
}