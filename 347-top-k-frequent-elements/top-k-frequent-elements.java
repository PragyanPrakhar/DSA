class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans[]=new int[k];
        int ind=0;
        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(hm.entrySet());
        for(int i=0;i<k;i++)
        {
            ans[ind++]=pq.poll().getKey();
        }
        return ans;
        
    }
}