class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1) return 1;
        int maxLength=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int start=0;
        int end=0;
        for(end=0;end<s.length();end++){
            if(hm.containsKey(s.charAt(end))){
                start=start<hm.get(s.charAt(end))+1?hm.get(s.charAt(end))+1:start;
            }
            maxLength=Math.max(maxLength,(end-start+1));
            hm.put(s.charAt(end),end);
        }
        return maxLength;
    }
}