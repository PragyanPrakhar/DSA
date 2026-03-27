class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < nums.length; end++) {
            
            // Maintain maxDeque (decreasing)
            while (!maxDeque.isEmpty() && nums[end] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[end]);

            // Maintain minDeque (increasing)
            while (!minDeque.isEmpty() && nums[end] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[end]);

            // Shrink window if invalid
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                
                if (nums[start] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                if (nums[start] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}