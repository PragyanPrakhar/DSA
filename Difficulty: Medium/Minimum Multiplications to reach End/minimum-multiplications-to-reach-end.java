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
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int steps;
    Pair(int node,int steps){
        this.node=node;
        this.steps=steps;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,0));
        int dist[]=new int[100000];
        int MOD=100000;
        Arrays.fill(dist,Integer.MAX_VALUE);
        while(!q.isEmpty()){
            int node=q.peek().node;
            int steps=q.peek().steps;
            q.remove();
            for(int it:arr){
                int num=(it*node)%MOD;
                if(steps+1 < dist[num]){
                    dist[num]=steps+1;
                    if(num==end) return steps+1;
                    q.add(new Pair(num,steps+1));
                }
            }
        }
        return -1;
    }
}
