class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int start = 0, max = 0;

        for (int end = 0; end < fruits.length; end++) {
            freq.put(fruits[end], freq.getOrDefault(fruits[end], 0) + 1);

            while (freq.size() > 2) {
                freq.put(fruits[start], freq.get(fruits[start]) - 1);
                if (freq.get(fruits[start]) == 0) {
                    freq.remove(fruits[start]);
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
