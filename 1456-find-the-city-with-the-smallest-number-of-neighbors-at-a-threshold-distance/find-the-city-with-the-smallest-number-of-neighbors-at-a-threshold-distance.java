class Pair{
    int node;
    int weight;
    Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Pair> ans=new ArrayList<>();
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int arr[]:edges){
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
            adj.get(arr[1]).add(new Pair(arr[0],arr[2]));
        }
        int minNode=n;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            // ArrayList<Pair> temp=new ArrayList<>();
            int temp=bfs(n,i,adj,distanceThreshold);
            // ans.add(new Pair(i,temp));
            hm.put(i,temp);
        }
        int minDistance=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            minDistance=Math.min(minDistance,entry.getValue());
        }
        ArrayList<Integer> minNodes=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()==minDistance){
                minNodes.add(entry.getKey());
            }
        }
        int finalMaxAns=Integer.MIN_VALUE;
        for(int i=0;i<minNodes.size();i++)
        {
            finalMaxAns=Math.max(finalMaxAns,minNodes.get(i));
        }
        return finalMaxAns;
    }
    private int bfs(int n,int src,ArrayList<ArrayList<Pair>> adj,int distanceThreshold){
        int cnt=0;
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int weight=pq.peek().weight;
            pq.remove();
            for(Pair p:adj.get(node)){
                int adjNode=p.node;
                int edgeWeight=p.weight;
                if(weight+edgeWeight < dist[adjNode]){
                    dist[adjNode]=weight+edgeWeight;
                    pq.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]<=distanceThreshold){
                cnt++;
            }
        }
        return cnt;
    }
}