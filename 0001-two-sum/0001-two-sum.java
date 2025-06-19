class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashSet<Integer> hs=new HashSet<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]),i};
            }
            // hs.add(nums[i]);
            hm.put(nums[i],i);
        }
        return new int[]{-1,-1};
        
    }
}