class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        int j=0;
        for(int i=0;i<=n;i++){
            if(i==0){
                ans[j++]=0;
            }
            else{
                int k=i;
                int count=0;
                while(k!=0){
                    count+=(k&1);
                    k=k>>1;
                }
                ans[j++]=count;
            }
        }
        return ans;
    }
}