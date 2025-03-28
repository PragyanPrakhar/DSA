class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numVertices = isConnected.length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            arr.add(new ArrayList<Integer>());
        }
        int p = 0;
        for (int[] ar : isConnected) {
            for (int i = 0; i < ar.length; i++) {
                if (i != p && ar[i] == 1) {
                    arr.get(p).add(i);
                }
            }
            p++;
        }
        boolean vis[] = new boolean[isConnected.length + 1];
        int count = 0;
        for(int i=0;i<numVertices;i++){
            if(vis[i]==false){
                count++;
                dfs(i,numVertices,vis,arr);
            }
        }
        return count;
    }

    private void dfs(int source,int numVertices,boolean vis[],ArrayList<ArrayList<Integer>> arr){
        vis[source]=true;
        for(int it:arr.get(source)){
            if(vis[it]==false){
                // count++;
                // vis[it]=true;
                dfs(it,numVertices,vis,arr);
            }
        }
    }

}