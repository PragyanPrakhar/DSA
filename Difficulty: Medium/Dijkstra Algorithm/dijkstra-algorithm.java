class Pair{
    int node;
    int weight;
    Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int arr[]:edges){
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(src,0));
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int distance=pq.peek().weight;
            pq.remove();
            for(Pair p:adj.get(node)){
                int adjNode=p.node;
                int edgWeight=p.weight;
                if(distance+edgWeight < dist[adjNode]){
                    dist[adjNode]=distance+edgWeight;
                    pq.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;
        
    }
}