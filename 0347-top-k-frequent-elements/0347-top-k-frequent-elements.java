class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket=new List[nums.length+1];
        for(int i:hm.keySet()){
            int freq=hm.get(i);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        // int ans[]=new int[nums.length];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                ans.addAll(bucket[i]);
            }
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=ans.get(i);
        }
        return res;

        
    }
}