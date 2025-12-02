class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum= nums[0] + nums[1] + nums[2];
        int closestDifference=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                if(nums[i]+nums[start]+nums[end]==target){
                    closestDifference = 0;
                    closestSum = target;
                    return closestSum;
                }
                else if(nums[i]+nums[start]+nums[end] > target){
                    if(closestDifference > Math.abs((nums[i]+nums[start]+nums[end])-target)){
                        closestDifference = Math.abs((nums[i]+nums[start]+nums[end])-target);
                        closestSum = nums[i]+nums[start]+nums[end];
                    }
                    end--;
                }
                else{
                    if(closestDifference > Math.abs((nums[i]+nums[start]+nums[end])-target)){
                        closestDifference = Math.abs((nums[i]+nums[start]+nums[end])-target);
                        closestSum = nums[i]+nums[start]+nums[end];
                    }
                    start++;
                }

            }
        }
        return closestSum;
    }
}