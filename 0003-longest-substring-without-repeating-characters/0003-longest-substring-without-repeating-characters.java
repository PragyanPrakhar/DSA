class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int start=0;
        int end=0;
        int maxLen=0;
        while(end < s.length()){
            while(hs.contains(s.charAt(end))){
                hs.remove(s.charAt(start));
                start++;
            }
            if(!hs.contains(s.charAt(end))){
                hs.add(s.charAt(end));
                maxLen=Math.max(end-start+1 , maxLen);
            } 
            end++;
        }
        return maxLen;
    }
}