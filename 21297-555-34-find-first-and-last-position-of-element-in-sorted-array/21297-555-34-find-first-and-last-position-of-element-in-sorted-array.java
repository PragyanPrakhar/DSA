class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        boolean found = false;
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<target)
            {
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                if(mid > 0 && nums[mid]==nums[mid-1])
                {
                    high=mid-1;
                }
                else
                {
                    ans[0]=mid;
                    break;
                }
            }
        }
        low=0;
        high=nums.length-1;
        while(low <= high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<target)
            {
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                if(mid<nums.length-1 && nums[mid]==nums[mid+1])
                {
                    low=mid+1;
                }
                else
                {
                    ans[1]=mid;
                    break;
                }
            }
        }
        return ans;

    }
}