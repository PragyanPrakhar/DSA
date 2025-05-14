class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        int dp[][]=new int[s.length()][s2.length()];
        for(int ar[]:dp) Arrays.fill(ar,-1);
        return solve(s.length()-1,s.length()-1,dp,s,s2);
    }
    private int solve(int ind1,int ind2,int dp[][],String s1,String s2){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return 1+solve(ind1-1,ind2-1,dp,s1,s2);
        }
        return dp[ind1][ind2]=Math.max(solve(ind1-1,ind2,dp,s1,s2),solve(ind1,ind2-1,dp,s1,s2));

    }
}