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
            int div = pile / k;
            hours += div;
            if (pile % k != 0) {
                hours++;
            }
        }
        return hours <= h;
    }
}