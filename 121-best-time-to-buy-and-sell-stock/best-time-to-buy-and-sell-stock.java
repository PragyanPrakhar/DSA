class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int cp=prices[0];
        for(int i=1;i<prices.length;i++){
            if(cp>prices[i]){
                cp=prices[i];
            }
            else{
                int profit=prices[i]-cp;
                ans=Math.max(ans,profit);
            }
        }
        return ans;
    }
}