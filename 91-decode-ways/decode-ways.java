class Solution {
    public int numDecodings(String s) {
        int ind=0;
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(ind,s,dp);
    }
    private int solve(int ind,String s,int dp[]){
        if(ind==s.length()) return 1;
        if(s.charAt(ind)=='0') return 0;
        if(dp[ind]!=-1) return dp[ind];

        int jump=0;
        if(ind+1 < s.length()  && s.charAt(ind)-'0' !=0){
            int tens=s.charAt(ind)-'0';
            int ones=s.charAt(ind+1)-'0';
            if(((tens*10)+(ones))<=26){
                jump=solve(ind+2,s,dp);
            }
        }
        int not_jump=0;
        if(s.charAt(ind)-'a'!=0){
            not_jump=solve(ind+1,s,dp);
        }
        return dp[ind]=jump+not_jump;
    }
}