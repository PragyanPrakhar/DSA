class Solution {
    public boolean isAnagram(String s, String t) {
        char charArray[]=new char[26];
        for(int i=0;i<s.length();i++){
            charArray[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            charArray[t.charAt(i)-'a']--;
        }
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]!=0) return false;
        }
        return true;
    }
}