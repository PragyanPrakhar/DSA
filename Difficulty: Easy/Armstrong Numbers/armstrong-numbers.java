// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int sum=0;
        int num=n;
        while(num!=0){
            int rem=num%10;
            sum+=(rem*rem*rem);
            num/=10;
        }
        return sum==n;
        
    }
}