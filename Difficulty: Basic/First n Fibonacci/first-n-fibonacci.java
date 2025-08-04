// User function Template for Java

class Solution {
    // Function to return list containing first n fibonacci numbers.
    public static int[] fibonacciNumbers(int n) {
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            res[i]=solve(i);
        }
        return res;
    }
    private static int solve(int n){
        if(n==0 || n==1) {
            return n;
        }
        return solve(n-1)+solve(n-2);
    }
}