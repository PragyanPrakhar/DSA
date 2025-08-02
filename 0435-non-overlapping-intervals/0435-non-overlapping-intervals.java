class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // sort by end time
        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++; // overlap, need to remove one
            } else {
                prevEnd = intervals[i][1]; // no overlap, update end
            }
        }

        return count;
    }
}
