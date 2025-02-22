//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int dp[][]=new int[arr.length][target+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return check(arr,target,arr.length-1,dp);
    }
    private static boolean check(int arr[],int target,int n,int dp[][]){
        if(target==0){
            return true;
        }
        if(n==0){
            if(arr[n]==target){
                dp[n][target]=1;
                return true;
            }
            else{
                dp[n][target]=0;
                return false;
            }
        }
        if(dp[n][target]!=-1) return dp[n][target]==0?false:true;
        boolean not_take=check(arr,target,n-1,dp);
        boolean take=false;
        if(target>=arr[n]){
            take=check(arr,target-arr[n],n-1,dp);
        }
        dp[n][target]=(take || not_take)?1:0;
        return (take||not_take);
    }
}