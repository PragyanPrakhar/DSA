class Solution {
    public int countPrimes(int n) {
        if(n==0) return 0;
        boolean sot[]=new boolean[n+1];
        Arrays.fill(sot,true);
        sot[0]=false;
        sot[1]=false;
        for(int i=2;i*i<=n;i++){
            if(sot[i]){
                for(int mul=i*i;mul<=n;mul+=i){
                    sot[mul]=false;
                }
            }
        }
        int cnt=0;
        for(int i=2;i<n;i++){
            if(sot[i]) cnt++;
        }
        return cnt;
    }
}