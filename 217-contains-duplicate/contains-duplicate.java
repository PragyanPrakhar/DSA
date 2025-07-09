class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        // hs.add(nums[i])
        for(int num:nums) hs.add(num);
        return hs.size()<nums.length;
    }
}