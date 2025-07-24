class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map from element to its next greater element in nums2
        HashMap<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Iterate over nums2 to fill nextGreater map
        for (int num : nums2) {
            // While current num > stack's top element, 
            // current num is the next greater element for that top element
            while (!st.isEmpty() && num > st.peek()) {
                nextGreater.put(st.pop(), num);
            }
            st.push(num);
        }
        // For elements left in stack, no next greater element exists
        while (!st.isEmpty()) {
            nextGreater.put(st.pop(), -1);
        }

        // Build result for nums1 by lookup in nextGreater map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }
}
