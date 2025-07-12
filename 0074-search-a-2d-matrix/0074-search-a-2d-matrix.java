class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int temp[]=new int[rows*cols];
        int idx=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                temp[idx++]=matrix[i][j];
            }
        }
        int low=0;
        int high=temp.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(temp[mid]==target) return true;
            if(temp[mid]<target) low=mid+1;
            else{
                high=mid-1;
            }
        }
        return false;       
    }
}