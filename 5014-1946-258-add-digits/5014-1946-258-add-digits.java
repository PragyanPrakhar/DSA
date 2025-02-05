class Solution {
    public int addDigits(int num) {
        if(num==0) return num;
        if(num / 10 == 0) return num;
        int prevSum=0;
        int temp=num;
        int number=num;
        while(number/10 != 0)
        {
            int rem=temp%10;
            prevSum+=rem;
            temp/=10;
            if(temp==0)
            {
                temp=prevSum;
                number=prevSum;
                prevSum=0;
            }
        }
        return number;
        
    }
}