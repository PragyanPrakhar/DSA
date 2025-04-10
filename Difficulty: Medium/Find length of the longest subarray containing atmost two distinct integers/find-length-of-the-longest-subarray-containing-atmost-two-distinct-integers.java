//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int totalElements(Integer[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int start = 0, maxLen = 0;

        for (int end = 0; end < arr.length; end++) {
            freq.put(arr[end], freq.getOrDefault(arr[end], 0) + 1);

            while (freq.size() > 2) {
                freq.put(arr[start], freq.get(arr[start]) - 1);
                if (freq.get(arr[start]) == 0) {
                    freq.remove(arr[start]);
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
