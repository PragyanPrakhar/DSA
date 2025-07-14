class Node{
    int first;
    int second;
    int third;
    Node(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int vis[][]=new int[rows][cols];
        Queue<Node> q=new LinkedList<>();
        int dist[][]=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dist[row][col]=steps;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int delRow=row+i;
                    int delCol=col+j;
                    if((i==0 || j==0)&&(delRow>=0) && (delCol>=0) && (delRow<rows) && (delCol < cols) && (vis[delRow][delCol]==0)){
                        q.add(new Node(delRow,delCol,steps+1));
                        vis[delRow][delCol]=1;
                    }
                }
            }
        }
        return dist;
    }
}