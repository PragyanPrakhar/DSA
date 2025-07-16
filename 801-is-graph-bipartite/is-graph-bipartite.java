class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        int colors[]=new int[n];
        for(int i=0;i<n;i++){
            if(colors[i]==0){
                if(!bfs(graph,i,colors)) return false;
            }
        }
        return true;
    }
    private boolean bfs(int graph[][],int startNode,int colors[]){
        Queue<Integer> q=new LinkedList<>();
        colors[startNode]=1;
        q.offer(startNode);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int ne:graph[node]){
                if(colors[ne]==0){
                    colors[ne]=-colors[node];
                    q.offer(ne);
                }
                else if(colors[node]==colors[ne]) return false;
            }
        }
        return true;
    }
}