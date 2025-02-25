class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //Tabulation Approach --> Shifting Of Index for writing the base case.
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        int m=text1.length();
        int n=text2.length();
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];


        // return solve(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    //Recursive and memoized code
    // private int solve(String text1,String text2,int m,int n,int dp[][]){
    //     if(m<0 || n<0) return 0;
    //     if(dp[m][n]!= -1) return dp[m][n];
    //     if(text1.charAt(m)==text2.charAt(n)) return 1+solve(text1,text2,m-1,n-1,dp);
    //     return dp[m][n]=Math.max(solve(text1,text2,m-1,n,dp),solve(text1,text2,m,n-1,dp));
    // }
}