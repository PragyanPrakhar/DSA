class Solution {
    private int findDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int sum = findDigitSum(num);
            map.putIfAbsent(sum, new PriorityQueue<>(Collections.reverseOrder()));
            map.get(sum).add(num);
        }

        int maxSum = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() > 1) {
                int first = pq.poll();  // Get the largest number
                int second = pq.poll(); // Get the second largest number
                maxSum = Math.max(maxSum, first + second);
            }
        }

        return maxSum;
    }
}
