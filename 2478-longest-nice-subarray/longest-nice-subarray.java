class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l=0,len=1,usedBits=0;
        for(int r=0;r<nums.length;r++){
            while((nums[r] & usedBits)!=0){
                usedBits^=nums[l];
                l++;
            }
            usedBits|=nums[r];
            len=Math.max(len,r-l+1);
        }
        return len;
    }
}