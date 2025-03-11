class Solution {
    public int maxChunksToSorted(int[] arr) {
        int numberOfChunks = 0;
        int prefixMaximum = 0; // Should start from 0 (indices are 0-based)
        
        for (int i = 0; i < arr.length; i++) { // Include the last element
            prefixMaximum = Math.max(prefixMaximum, arr[i]); // Update max value
            
            // If max value equals the current index, we can make a chunk
            if (prefixMaximum == i) {
                numberOfChunks++;
            }
        }
        return numberOfChunks;
    }
}

// The approach is simple: iterate over the array while keeping track of the
// prefix maximum. Whenever the prefix maximum matches the current index, it
// indicates a valid chunk. For example, in [1, 0, 2, 3, 4], the valid chunks
// are [1, 0], [2], [3], and [4], resulting in 4 chunks in total.

// For a more detailed explanation, check out My Solution.