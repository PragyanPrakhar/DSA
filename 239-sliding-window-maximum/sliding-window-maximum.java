class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int n = nums.length;
        int ai = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            if (i >= k - 1) {
                ans[ai++] = nums[q.peek()];
            }
        }
        return ans;
    }
}