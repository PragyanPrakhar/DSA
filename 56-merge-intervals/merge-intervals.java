class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < start) {
                ans.add(new int[]{start, end});
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], end);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
