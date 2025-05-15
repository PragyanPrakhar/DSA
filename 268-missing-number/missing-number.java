class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int arrXor=0;
        for(int i=0;i<nums.length;i++)
        {
            arrXor^=nums[i];
        }
        int xorSum=0;
        for(int i=0;i<=n;i++)
        {
            xorSum^=i;
        }
        return (xorSum ^ arrXor);
    }
}