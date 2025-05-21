class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count=0;
        int lastTakenInterval[]=new int[]{intervals[0][0],intervals[0][1]};

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (lastTakenInterval[1]>start) {
                count++;
                if(lastTakenInterval[1]>end){
                    lastTakenInterval[1]=end;
                }

            } else {
                lastTakenInterval[0]=start;
                lastTakenInterval[1]=end;
            }
        }
        return count;
    }
}