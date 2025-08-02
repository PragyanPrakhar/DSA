class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> ans=new ArrayList<>();
        int i=0;
        while(i< n){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(ans.isEmpty() || ans.get(ans.size()-1)[1]<start){
                ans.add(new int[]{start,end});
            }
            else{
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],end);
            }
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
        
    }
}