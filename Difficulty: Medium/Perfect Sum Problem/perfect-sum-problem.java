//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        if(target==0) return (int)Math.pow(2,countZeroes(nums));
        int n=nums.length;
        int dp[][]=new int[n][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int totalZeroes=countZeroes(nums);
        int arr[]=new int[n-totalZeroes];
        int idx=0;
        for(int i:nums){
            if(i!=0)
            {
                arr[idx++]=i;
            }
        }
        return solve(arr,arr.length-1,target,dp)*(1<<countZeroes(nums));
    }
    private int solve(int nums[],int ind,int target,int dp[][]){
        if(target==0) return 1;
        if(ind==0){
            return nums[0]==target?1:0;
        }

        if(dp[ind][target]!=-1) return dp[ind][target];
        int not_take=solve(nums,ind-1,target,dp);
        int take=0;
        if(nums[ind]<=target){
            take=solve(nums,ind-1,target-nums[ind],dp);
        }
        return dp[ind][target]=take+not_take;
        
    }
    private int countZeroes(int nums[]){
        int c=0;
        for(int i:nums){
            if(i==0)c++;
        }
        return c;
    }
}