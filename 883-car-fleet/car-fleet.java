class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int pair[][]=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        //sorting the stack on the basis of position in descending order
        Arrays.sort(pair,(a,b)->Integer.compare(b[0],a[0]));
        Stack<Double> stack=new Stack<>();
        // the idea to solve this question is whenever the time taken to reach the target of a car which is behind the some other car is less than that , then they will definitely form the fleet .
        for(int[] p:pair){
            stack.push((double)(target-p[0])/p[1]);
            if(stack.size()>=2){
                if(stack.peek()<=stack.get(stack.size()-2)){
                    stack.pop();
                }
            }
        }
        return stack.size();

    }
}