class Solution {
    long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = (n + 1) / 2;
        return (int)((pow(5,even)%MOD * pow(4,odd))%MOD);
    }
    public long pow(long x, long y)
    {
        if(y==0) return 1;
        if(y==1) return x;
        if(y < 1) return pow(1/x , -y);
        long result=pow((x*x)%MOD , y/2);
        if(y%2 != 0) 
        {
            result=(result*x)%MOD;
        }
        return result%MOD;
    }
}