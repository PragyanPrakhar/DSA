class Node{
    int profit;
    int index;
    Node(int profit,int index){
        this.profit=profit;
        this.index=index;
    }
}
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Node> q=new PriorityQueue<>((a,b)->b.profit-a.profit);
        for(int i=0;i<profit.length;i++){
            q.add(new Node(profit[i],i));
        }
        Arrays.sort(worker);
        int idx=worker.length-1;
        int maxProfit=0;
        while(idx>=0 && !q.isEmpty()){
            int prof=q.peek().profit;
            int index=q.peek().index;
            if(difficulty[index]<=worker[idx]){
                maxProfit+=prof;
                idx--;
            }
            else{
                q.remove();
            }
            // q.remove();
        }
        return maxProfit;

    }
}