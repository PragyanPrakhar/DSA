//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    int countPartitions(int[] arr, int d) {
        int totalSum=Arrays.stream(arr).sum();
        int targetSum=(totalSum-d)/2;
        if(targetSum<0) return 0;
        if(totalSum-d < 0) return 0;
        if((totalSum-d) % 2 !=0)return 0;
        int dp[][]=new int[arr.length][targetSum+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return solve(arr,arr.length-1,targetSum,dp);
    }
    private int solve(int arr[],int ind,int targetSum,int dp[][]){
        if(ind==0){
            if(targetSum==0 && arr[0]==0) return 2;
            if(targetSum==0 || arr[0]==targetSum) return 1;
            return 0;
        }
        if(dp[ind][targetSum]!=-1) return dp[ind][targetSum];
        int not_take=solve(arr,ind-1,targetSum,dp);
        int take=0;
        if(arr[ind]<=targetSum){
            take=solve(arr,ind-1,targetSum-arr[ind],dp);
        }
        return dp[ind][targetSum]=take+not_take;
    }
}
