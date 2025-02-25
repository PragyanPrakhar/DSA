//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends

class Solution {
    public int cutRod(int[] price) {
        int n=price.length;
        int dp[][]=new int[n][n+1];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(price,n,n-1,0,dp);
    }
    private int solve(int price[],int n,int ind,int count,int dp[][]){
        if(ind<0) return 0;
        if(count==n) return 0;
        if(dp[ind][count]!=-1) return dp[ind][count];
        int not_take=solve(price,n,ind-1,count,dp);
        int take=0;
        int rodLength=ind+1;
        if(count+rodLength <= n) take=price[ind]+solve(price,n,ind,count+rodLength,dp);
        return dp[ind][count]=Math.max(not_take,take);
    }
}