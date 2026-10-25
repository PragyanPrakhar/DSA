class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        HashSet<List<Integer>> hs=new HashSet<>();
        boolean[] used = new boolean[nums.length];
        recurr(nums,hs,new ArrayList<>(),used);
        for(List<Integer> list : hs){
            res.add(list);
        }
        // List
        return res;
    }

    private void recurr(int nums[], HashSet<List<Integer>> res, List<Integer> temp , boolean[] used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            temp.add(nums[i]);
            recurr(nums,res,temp,used);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}