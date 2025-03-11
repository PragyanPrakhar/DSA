class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int prevIndex[] = new int[nums.length];
        Arrays.fill(prevIndex, -1);
        int maxLength=0,lastIndex=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0)  && (1+dp[j]>dp[i])) {
                    dp[i]=dp[j]+1;
                    prevIndex[i]=j;
                }
            }
            if(dp[i]>maxLength){
                maxLength=dp[i];
                lastIndex=i;
            }
        }
        List<Integer> lis=new ArrayList<>();
        while(lastIndex!=-1){
            lis.add(nums[lastIndex]);
            lastIndex=prevIndex[lastIndex];
        }
        Collections.reverse(lis);
        return lis;
    }
}
// [4,8,10,240]