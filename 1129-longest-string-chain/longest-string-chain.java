class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=0;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPossible(words[j],words[i])){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
    private  boolean isPossible(String s,String t){
        if((t.length()-s.length())!=1){
            return false;
        }
        int m=s.length();
        int n=t.length();
        int i=0;
        int count=0;
        int j=0;
        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                if(count>1) return false;
                count++;
                j++;
            }
        }
        return i==m;
    }
}