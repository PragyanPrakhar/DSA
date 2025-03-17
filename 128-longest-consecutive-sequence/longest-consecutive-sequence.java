class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> hs=new HashSet<>();
        // hs.addAll(nums);
        for(int i:nums){
            hs.add(i);
        }
        // })
        int res=1;
        for(Integer x:hs){
            if(hs.contains(x-1)==false){
                int curr=1;
                while(hs.contains(x+curr)){
                    curr++;
                }
                res=Math.max(res,curr);
            }
        }
        return res;
    }
}