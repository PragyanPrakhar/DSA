class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
		for(int[] ar:dist)Arrays.fill(ar,(int)(1e9));
		for(int[] ar:edges){
			int u=ar[0];
			int v=ar[1];
			int wt=ar[2];
			dist[u][v]=wt;
			dist[v][u]=wt;
		}
		for(int i=0;i<n;i++) dist[i][i]=0;
		for(int via=0;via<n;via++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
				}
			}
		}
		int cntMax=n+1;
		int city=-1;
		for(int i=0;i<n;i++){
			int cnt=0;
			for(int j=0;j<n;j++){
				if(dist[i][j]<=distanceThreshold){
					cnt++;
				}
			}
			if(cnt<=cntMax){
				cntMax=Math.min(cnt,cntMax);
				city=Math.max(city,i);
			}
		}
		return city;
    }
}