class Solution {
    public int longestOnes(int[] nums, int k) {
        int countO=0;
        int start=0;
        int end=0;
        int maxLen=0;
        while(end < nums.length){
            if(nums[end]==0){
                countO++;
            }
            if(countO<=k){
                maxLen=Math.max(maxLen , end-start+1);
            }
            while(countO>k){
                if(nums[start]==0) countO--;
                start++;
            }
            end++;
        }
        return maxLen;
    }
}