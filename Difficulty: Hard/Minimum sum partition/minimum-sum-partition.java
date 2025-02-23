//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public int minDifference(int nums[]) {
        // Your code goes here
        int totalSum=Arrays.stream(nums).sum();
        boolean dp[][]=new boolean[nums.length][totalSum+1];
        for(int i=0;i<nums.length;i++)
        {
            dp[i][0]=true;
        }
        if(nums[0]<=totalSum) dp[0][totalSum]=true;
        for(int i=1;i<nums.length;i++)
        {
            for(int target=1;target<=totalSum;target++){
                boolean not_take=dp[i-1][target];
                boolean take=false;
                if(nums[i]<=target){
                    take=dp[i-1][target-nums[i]];
                }
                dp[i][target]=take||not_take;
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<=totalSum;i++){
            if(dp[nums.length-1][i]==true){
                int s2=totalSum-i;
                mini=Math.min(mini,Math.abs(s2-i));
            }
        }
        return mini;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends