class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int start=0;
        int end=0;
        int maxLen=0;
        while(end<s.length()){
            if(hm.containsKey(s.charAt(end))){
                start=Math.max(start,hm.get(s.charAt(end))+1);
            }
            maxLen=Math.max(maxLen,end-start+1);
            hm.put(s.charAt(end),end);
            end++;
        }
        return maxLen;
    }
}