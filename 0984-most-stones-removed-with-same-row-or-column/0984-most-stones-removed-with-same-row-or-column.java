class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        boolean vis[]=new boolean[stones.length];
        int components=0;
        for(int i=0;i<stones.length;i++){
            if(!vis[i]) {
                bfs(stones,vis,i);
                components++;
            }
        }
        return stones.length-components;

    }
    private void bfs(int stones[][],boolean vis[],int index){
        Queue<Integer> q=new LinkedList<>();
        q.add(index);
        vis[index]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<stones.length;i++){
                if(!vis[i] && (stones[i][0] == stones[curr][0] || stones[i][1] == stones[curr][1])){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
    }
}