class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length()-1;
        int n=text2.length()-1;
        int dp[][]=new int[m+1][n+1];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(dp,m,n,text1,text2);
    }
    private int solve(int dp[][],int m,int n,String text1,String text2){
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(text1.charAt(m)==text2.charAt(n)){
            return 1+solve(dp,m-1,n-1,text1,text2);
        }
        return dp[m][n]= Math.max(solve(dp,m-1,n,text1,text2),solve(dp,m,n-1,text1,text2));
    }
}