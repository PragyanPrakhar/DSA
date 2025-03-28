class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        int row=image.length;
        int col=image[0].length;
        int ans[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ans[i][j]=image[i][j];
            }
        }
        dfs(sr,sc,image,ans,color);
        return ans;
    }
    private void dfs(int sr,int sc,int image[][],int ans[][],int color){
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int delRow=sr+i;
                int delCol=sc+j;
                if((i==0 || j==0) && delRow>=0 && delRow<n && delCol >=0 && delCol<m && image[delRow][delCol]==image[sr][sc] && ans[delRow][delCol]!=color){
                    dfs(delRow,delCol,image,ans,color);
                }
            }
        }
    } 
}