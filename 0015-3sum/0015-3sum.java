class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> hs=new HashSet<>();
        Arrays.sort(nums);
        // int i=0;
        // while(i<nums.length-2){
            for(int i=0;i<nums.length-2;i++){
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    int sum=nums[j]+nums[k];
                    if(sum==-nums[i]){
                        hs.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        j++;
                        k--;
                    }
                    else if(sum > -nums[i]) k--;
                    else j++;
                    // i++;        
                }
        }
        return new ArrayList<>(hs);
    }
}