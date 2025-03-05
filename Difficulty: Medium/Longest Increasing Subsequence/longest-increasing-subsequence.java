//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    static int lis(int arr[]) {
        ArrayList<Integer> ar=new ArrayList<>();
        ar.add(arr[0]);
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(ar.get(ar.size()-1)<arr[i]){
                ar.add(arr[i]);
                count++;
            }
            else{
                int ind=binarySearch(ar,arr[i]);
                ar.set(ind,arr[i]);
            }
        }
        return count;
    }
    private static  int binarySearch(ArrayList<Integer> ar,int element){
        int low=0;
        int high=ar.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            // if(ar.get(mid)<=element){
            //     low=mid+1;
            // }
            // else{
            //     high=mid-1;
            // }
            if(ar.get(mid) >= element) {
                high = mid - 1;  // Move left to find the first element >= element
            } else {
                 low = mid + 1;
            }
        }
        return low;
    }
}