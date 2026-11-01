class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        boolean even = (nums.length % 2 == 0);
        int median = even ? ((nums[n/2] + nums[(n/2)-1])/2) : (nums[n/2]);
        int count=0;
        for(int num:nums){
            count+=Math.abs(num-median);
        }
        return count;

    }
}