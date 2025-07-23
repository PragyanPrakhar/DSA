// User function Template for Java
class Pair{
    int number;
    int steps;
    Pair(int number,int steps){
        this.number=number;
        this.steps=steps;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q=new LinkedList<>();
        int MOD=100000;
        q.add(new Pair(start,0));
        int minSteps=Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(!q.isEmpty()){
            int number=q.peek().number;
            int steps=q.peek().steps;
            q.remove();
            if(number==end) return steps;
            for(int i=0;i<arr.length;i++){
                int newNumber=(number*arr[i])%MOD;
                if(!hm.containsKey(newNumber)){
                    q.add(new Pair(newNumber,steps+1));
                    hm.put(newNumber,steps+1);
                }
                
            }
        }
        return -1;
        
    }
}
