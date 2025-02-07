class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int n=highLimit-lowLimit+1;
        int boxNumber[]=new int[46];
        for(int i=lowLimit;i<=highLimit;i++)
        {
            int sumOfDigits=findingSumOfDigits(i);
            boxNumber[sumOfDigits]+=1;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=45;i++)
        {
            max=Math.max(max,boxNumber[i]);
        }
        return max;
    }
    private int findingSumOfDigits(int n)
    {
        if(n<=9) return n;
        int sum=0;
        while(n!=0)
        {
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        return sum;
    }
}