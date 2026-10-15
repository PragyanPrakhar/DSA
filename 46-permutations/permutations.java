class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean used[]=new boolean[nums.length];
        backtrack(nums,used,ans,new ArrayList<>());
        return ans;
    }
    private void backtrack(int nums[] , boolean used[] , List<List<Integer>> ans, List<Integer> path){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            path.add(nums[i]);
            backtrack(nums,used,ans,path);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }
    
}