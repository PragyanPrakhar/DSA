//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int dp[][]=new int[arr.length][arr.length];
        for(int ar[]:dp)Arrays.fill(ar,-1);
        return solve(1,arr.length-1,arr,dp);
    }
    private static int solve(int i,int j,int arr[],int dp[][]){
        if(i==j) return 0;
        int min=1234566773;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<=j-1;k++){
            min=Math.min(min,((arr[i-1]*arr[k]*arr[j])+solve(i,k,arr,dp)+solve(k+1,j,arr,dp)));
        }
        return dp[i][j]=min;
    }
}