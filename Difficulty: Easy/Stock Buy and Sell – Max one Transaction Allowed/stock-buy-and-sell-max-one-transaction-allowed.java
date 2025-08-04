// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int maxProfit=0;
        int buyPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buyPrice){
                maxProfit=Math.max(maxProfit,prices[i]-buyPrice);
            }
            else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }
}