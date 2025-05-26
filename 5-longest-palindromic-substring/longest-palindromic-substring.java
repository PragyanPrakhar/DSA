class Solution {
    public String longestPalindrome(String s) {
        int maxLength=1;
        String ans=s.substring(0,1);
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isPallindrome(s.substring(i,j))){
                    if(j-i > maxLength){
                        ans=s.substring(i,j);
                        maxLength=j-i;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPallindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}