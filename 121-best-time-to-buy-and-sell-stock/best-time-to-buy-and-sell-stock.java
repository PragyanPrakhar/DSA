class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=Integer.MIN_VALUE;
        int buyPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buyPrice){
                int sp=prices[i]-buyPrice;
                maxProfit=Math.max(sp,maxProfit);
            }
            else{
                buyPrice=prices[i];
            }
        }
        return maxProfit==Integer.MIN_VALUE ? 0 : maxProfit;

    }
}