//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        int dp[]=new int[n];// to store the length of the lIS at each index
        int prevIndex[]=new int[n];// to track the prevIndex
        Arrays.fill(dp,1);
        Arrays.fill(prevIndex,-1);
        int maxLength=0,lastIndex=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    prevIndex[i]=j;
                }
            }
            if(dp[i]>maxLength){
                maxLength=dp[i];
                lastIndex=i;
            }
        }
        
        ArrayList<Integer> lis=new ArrayList<>();
        while(lastIndex!=-1){
            lis.add(arr[lastIndex]);
            lastIndex=prevIndex[lastIndex];
        }
        Collections.reverse(lis);
        return lis;
        
        
    }
}
