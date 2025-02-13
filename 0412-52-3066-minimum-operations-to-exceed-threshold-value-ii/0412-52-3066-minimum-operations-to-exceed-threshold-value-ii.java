class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numberOfOperations = 0;

        for (int num : nums) {
            pq.offer(num);
        }

        while (pq.size() > 1 && pq.peek() < k) {
            int first = pq.poll();
            int second = pq.poll();
            if (second < k && first * 2 < k && first * 2 + second < k) {
                int newElement = first * 2 +second;
                pq.add(newElement);
            } else {
                pq.offer(k);
            }
            numberOfOperations++;
        }

        return (pq.peek() >= k) ? numberOfOperations : -1;
    }
}
