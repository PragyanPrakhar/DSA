class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int num = n;
        
        while (num != 1 && !seen.contains(num)) {
            seen.add(num);
            int squaredNumber = 0;
            while (num != 0) {
                int rem = num % 10;
                squaredNumber += (rem * rem);
                num /= 10;
            }
            num = squaredNumber;
        }
        
        return num == 1;
    }
}
