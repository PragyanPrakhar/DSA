class Solution {
    public boolean search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                return true;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high])
            {
                low++;
                high--;
                continue;
            }
            // If the left part is sorted
             if(nums[low]<=nums[mid])
            {
                if(target>=nums[low] && target<= nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            // If the right part is sorted
            else
            {
                if(nums[mid]<=target && target<=nums[high])
                {
                    // high=mid-1;
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }       
        }
        return false;
    }
}