class Node{
    int row;
    int col;
    Node(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows=image.length;
        int cols=image[0].length;
        int vis[][]=new int[rows][cols];
        int originalColor=image[sr][sc];
        if(image[sr][sc]==color) return image;
        vis[sr][sc]=1;
        image[sr][sc]=color;
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(sr,sc));
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int delRow=row+i;
                    int delCol=col+j;
                    if((i==0 || j==0) && (i!=j) && delRow>=0 && delRow<rows && delCol>=0 && delCol<cols && vis[delRow][delCol]==0 && image[delRow][delCol]==originalColor){
                        vis[delRow][delCol]=1;
                        image[delRow][delCol]=color;
                        q.add(new Node(delRow,delCol));
                    }
                }
            }
        }
        return image;
    }
}