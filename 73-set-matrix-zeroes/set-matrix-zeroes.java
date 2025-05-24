class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isZeroPresent=false;
        int rows[]=new int[matrix.length];
        int cols[]=new int[matrix[0].length];
        Arrays.fill(rows,-1);
        Arrays.fill(cols,-1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows[i]=0;
                    cols[j]=0;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows[i]==0 || cols[j]==0){
                    matrix[i][j]=0;
                }
            }
        }
    }
    private void setMatrix(int m,int n,int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if((i==m || j==n)&&(matrix[i][j]!=0)){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}