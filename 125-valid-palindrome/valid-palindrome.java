class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                sb.append(s.charAt(i));
            }
        }
        return checkPallindrome(sb.toString());
    }
    private boolean checkPallindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}