class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int pt=1;
        for(int i=0;i<nums.length;i++)
        {
            pt*=nums[i];
            max=Math.max(max,pt);
            if(pt==0)
            {
                pt=1;
            }
        }
        pt=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            pt*=nums[i];
            max=Math.max(max,pt);
            if(pt==0)
            {
                pt=1;
            }
        }
        return max;
    }
}