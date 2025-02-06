class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int count = 0;

        // Count all pairs and their products
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Calculate the number of valid tuples
        for (Map.Entry<Integer, Integer> entry : productCount.entrySet()) {
            int freq = entry.getValue();
            if (freq > 1) {
                count += (freq * (freq - 1)) * 4;
            }
        }

        return count;
    }
}
