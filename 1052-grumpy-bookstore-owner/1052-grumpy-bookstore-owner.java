class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start=0;
        int end=0;
        int tempMinutes=minutes;
        int sum=0;
        int maxSum=0;
        int initiallySatisfiedCustomers=0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]==0){
                initiallySatisfiedCustomers+=customers[i];
            }
        }
        for(int i=0;i<tempMinutes;i++){
            if(grumpy[i]==1) sum+=customers[i];
        }
        maxSum=sum;
        for(int i=tempMinutes;i<grumpy.length;i++){
            if(grumpy[i]==1){
                sum=sum+customers[i];
            }
            if(grumpy[i-tempMinutes] == 1) sum=sum-customers[i-tempMinutes];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum+initiallySatisfiedCustomers;

    }
}