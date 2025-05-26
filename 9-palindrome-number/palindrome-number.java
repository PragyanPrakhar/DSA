class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int temp=x;
        int revNumber=0;
        int rem=0;
        while(temp!=0){
            rem=temp%10;
            revNumber=revNumber*10+rem;
            temp/=10;
        }
        System.out.print("Reversed Number :- "+revNumber);
        return x==revNumber;

    }
}