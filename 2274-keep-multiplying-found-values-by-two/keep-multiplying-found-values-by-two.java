class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> hs=new HashSet<>();
        for(int it:nums){
            hs.add(it);
        }
        while(hs.contains(original)){
            original *= 2;
        }
        return original;

    }
}