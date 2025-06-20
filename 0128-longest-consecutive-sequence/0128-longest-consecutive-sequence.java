class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++) hs.add(nums[i]);
        int ans=0;
        for(int num:hs){
            if(!hs.contains(num-1)){
                int currentStreak=1;
                int currentNum=num;
                while(hs.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                ans=Math.max(currentStreak,ans);
            }
        }
        return ans;

    }
}