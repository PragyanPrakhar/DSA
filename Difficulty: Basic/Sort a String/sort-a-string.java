// User function Template for Java
class Solution {
    String sort(String s) {
        // code here
        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        String ans=new String(arr);
        return ans;
    }
}