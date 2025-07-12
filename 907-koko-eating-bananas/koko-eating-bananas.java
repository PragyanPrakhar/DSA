class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i : piles) {
            right = Math.max(right, i);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (canEat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean canEat(int piles[], int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            if (hours > h)
                return false;
            hours += (pile % k == 0) ? pile / k : (pile / k) + 1;
        }
        return h >= hours;
    }
}