class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int start=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int end=0;end<s.length();end++){
            if(hm.containsKey(s.charAt(end))){
                start=Math.max(start,hm.get(s.charAt(end))+1);
            }
            hm.put(s.charAt(end),end);
            ans=Math.max(ans,end-start+1);
        }
        return ans;
    }
}