import java.util.*;
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int[][] dp=new int[W+1][n+1];
        // for(int arr[]:dp){
        //     Arrays.fill(arr,-1);
        // }
        for(int i=0;i<=W;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        
        for(int i=1;i<=W;i++){
            for(int j=1;j<=n;j++){
                if(wt[j-1]<=i){
                    dp[i][j]=Math.max((val[j-1]+dp[i-wt[j-1]][j-1]) , dp[i][j-1]);
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[W][n];
        // return knpsck(W,val,wt,val.length,dp);
    }
    private int knpsck(int w, int val[], int wt[], int n, int dp[][]){
        if(w==0 || n==0) return 0;
        
        if(dp[w][n] != -1) return dp[w][n];
        if(wt[n-1]<=w){
            return Math.max((val[n-1]+knpsck(w-wt[n-1],val,wt,n-1,dp)) , knpsck(w,val,wt,n-1,dp));
        }
        else{
            return knpsck(w,val,wt,n-1,dp);
        }
        
    }
}
