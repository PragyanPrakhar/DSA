//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int minElement=Integer.MAX_VALUE;
        for(int i=0;i<wt.length;i++){
            minElement=Math.min(wt[i],minElement);
        }
        if(minElement > capacity) return 0;
        int dp[][]=new int[wt.length][capacity+1];
        for(int[] ar:dp) Arrays.fill(ar,-1);
        return finding(val,wt,capacity,val.length-1,0,dp);
    }
    private static int finding(int[] val,int[] wt,int capacity,int ind,int totalWeightOfItems,int dp[][]){
        if(ind < 0) return 0;
        if(totalWeightOfItems > capacity) return 0;
        if(totalWeightOfItems > capacity) return 0;
        if(dp[ind][totalWeightOfItems]!=-1) return dp[ind][totalWeightOfItems];
        int not_pick=0+finding(val,wt,capacity,ind-1,totalWeightOfItems,dp);
        int pick=0;
        if((totalWeightOfItems+wt[ind])<=capacity){
            pick=val[ind]+finding(val,wt,capacity,ind,totalWeightOfItems+wt[ind],dp);
        }
        return dp[ind][totalWeightOfItems]=Math.max(pick,not_pick);
    }
}