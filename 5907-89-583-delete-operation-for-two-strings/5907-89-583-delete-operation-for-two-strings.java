class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][]=new int[m][n];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return (word1.length()-solve(word1, word2, m - 1, n - 1,dp))+(word2.length()-solve(word1,word2,m-1,n-1,dp));
    }

    private int solve(String word1, String word2, int m, int n,int dp[][]) {
        if(m<0 || n<0) return 0;
        if(word1.charAt(m)==word2.charAt(n)) return 1+solve(word1,word2,m-1,n-1,dp);
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]= Math.max(solve(word1,word2,m-1,n,dp),solve(word1,word2,m,n-1,dp)) ;
    }
}