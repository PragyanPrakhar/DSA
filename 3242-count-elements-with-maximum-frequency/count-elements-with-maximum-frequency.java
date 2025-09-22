class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> arr=new ArrayList<>(hm.values());
        int max_freq=Integer.MIN_VALUE;
        for(int num:arr){
            max_freq=Math.max(max_freq,num);
        }
        int cnt=0;
        for(int num:arr){
            if(num==max_freq){
                cnt+=num;
            }
        }
        return cnt;

    }
}