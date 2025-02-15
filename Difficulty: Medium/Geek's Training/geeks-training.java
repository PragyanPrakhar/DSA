//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Solution {
    public int maximumPoints(int arr[][]) {
        int ans=Integer.MIN_VALUE;
        int n=arr.length;
        int dp[][]=new int[n][4];
        for(int[] ar:dp)
        {
            Arrays.fill(ar,-1);
        }
        return findingMax(arr,arr.length-1,3,dp);
    }
    private int findingMax(int arr[][] , int day , int last , int[][] dp)
    {
        int maxi=0;
        if(day==0)
        {
            maxi=0;
            for(int i=0;i<=2;i++)
            {
                if(i!=last)
                {
                    maxi=Math.max(maxi,arr[0][i]);
                }
            }
            return dp[day][last]=maxi;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        for(int i=0;i<=2;i++)
        {
            if(i!=last)
            {
               int merits=arr[day][i]+findingMax(arr,day-1,i,dp);
               maxi=Math.max(maxi,merits);
            }
        }
        return dp[day][last] =maxi;
    }
}