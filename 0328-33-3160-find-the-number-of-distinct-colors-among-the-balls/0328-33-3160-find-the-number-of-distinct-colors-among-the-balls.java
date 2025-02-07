class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballToColor = new HashMap<>();
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        int ans[]=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball);
                int count = colorCount.get(oldColor) - 1;
                if (count == 0) {
                    colorCount.remove(oldColor);
                } else {
                    colorCount.put(oldColor, count);
                }
            }
            ballToColor.put(ball,color);
            colorCount.put(color,colorCount.getOrDefault(color,0)+1);
            ans[i]=colorCount.size();
        }
        return ans;
    }
}